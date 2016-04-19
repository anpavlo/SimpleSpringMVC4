package social;

import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;


public class SocialSignUp implements ConnectionSignUp {
    private UserDetailsManager userDetailsManager;

    public SocialSignUp(UserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }

    @Override
    public String execute(Connection<?> connection) {
        ApplicationUser appUser = new ApplicationUser.Builder()
                .userProfile(connection.fetchUserProfile())
                .connectionKey(connection.getKey())
                .imageUrl(connection.getImageUrl())
                .profileUrl(connection.getProfileUrl())
            .build();
        userDetailsManager.createUser(appUser.getSocialUser());
        return appUser.getSocialUser().getUserId();
    }

}
