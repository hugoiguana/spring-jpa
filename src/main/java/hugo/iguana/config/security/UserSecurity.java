package hugo.iguana.config.security;

import hugo.iguana.domain.enums.UserSystemProfile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class UserSecurity implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSecurity(Long id, String email, String senha, List<UserSystemProfile> perfis) {
        super();
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.authorities = perfis.stream().map(p -> new SimpleGrantedAuthority(p.getRole())).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}