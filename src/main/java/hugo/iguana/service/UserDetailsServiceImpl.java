package hugo.iguana.service;

import hugo.iguana.config.security.JWTUtil;
import hugo.iguana.config.security.UserSecurity;
import hugo.iguana.domain.UserSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserSystemService service;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserSystem u = service.getRepository().findByEmail(email);
        if (u == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserSecurity(u.getId(), u.getEmail(), u.getPassword(), u.getProfiles());
    }

    public UserSecurity authenticated() {
        try {
            return (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }

    public UsernamePasswordAuthenticationToken getAuthentication(String token) {
        if (jwtUtil.tokenValido(token)) {
            String userName = jwtUtil.getUserName(token);
            UserDetails user = loadUserByUsername(userName);
            return new UsernamePasswordAuthenticationToken(user, user.getAuthorities(), user.getAuthorities());
        }
        return null;
    }
}