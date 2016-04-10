package social;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Collection;
import java.util.Collections;

public class InMemoryUserDetailsService extends InMemoryUserDetailsManager {
    public InMemoryUserDetailsService() {
        super(Collections.singletonList(User.build("admin", "qwerty")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserDetails user = super.loadUserByUsername(username);
        } catch (UsernameNotFoundException ex) {
            super.createUser(new User(username));
        }
        return super.loadUserByUsername(username);
    }
}
