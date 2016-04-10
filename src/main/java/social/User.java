package social;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUser;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by krunch on 09.04.2016.
 */
public class User extends SocialUser {

    public User(String username, String password,
                boolean enabled,
                boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
                Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public User(String username) {
        super(username, "SocialUser", Collections.singletonList(new SimpleGrantedAuthority(Role.ROLE_USER.toString())));
    }

    public static User build(String username, String password) {
        GrantedAuthority user = new SimpleGrantedAuthority(Role.ROLE_USER.toString());
        return new User(username, password, Collections.singletonList(user));
    }


}
