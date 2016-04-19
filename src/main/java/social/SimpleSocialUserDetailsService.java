package social;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;


public class SimpleSocialUserDetailsService implements SocialUserDetailsService {

    private UserDetailsManager userDetailsManager;

    public SimpleSocialUserDetailsService(UserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }
 
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        UserDetails userDetails = userDetailsManager.loadUserByUsername(userId);
        return new SocialUser(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    }
}