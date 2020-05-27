package hugo.iguana.resource;

import hugo.iguana.config.security.JWTUtil;
import hugo.iguana.config.security.UserSecurity;
import hugo.iguana.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping(value = "/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {

        UserSecurity user = userDetailsService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);

        return ResponseEntity.noContent().build();
    }

}