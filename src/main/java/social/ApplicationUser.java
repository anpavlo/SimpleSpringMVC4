package social;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.security.SocialUser;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by roman.golyuk on 11.04.2016.
 */
public class ApplicationUser {
    private SocialUser socialUser;
    private UserProfile userProfile;
    private String profileUrl;
    private String imageUrl;
    private ConnectionKey connectionKey;

    public SocialUser getSocialUser() {
        return socialUser;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public void setSocialUser(SocialUser socialUser) {
        this.socialUser = socialUser;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ConnectionKey getConnectionKey() {
        return connectionKey;
    }

    public void setConnectionKey(ConnectionKey connectionKey) {
        this.connectionKey = connectionKey;
    }

    public static class Builder {
        private UserProfile userProfile;
        private String profileUrl;
        private String imageUrl;
        private ConnectionKey connectionKey;
        public Builder userProfile(UserProfile userProfile) {
            this.userProfile = userProfile;
            return this;
        }

        public Builder profileUrl(String profileUrl) {
            this.profileUrl = profileUrl;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder connectionKey(ConnectionKey connectionKey) {
            this.connectionKey = connectionKey;
            return this;
        }

        public ApplicationUser build() {
            String username = userProfile.getUsername();
            if (username == null) {
                username = userProfile.getName();
            }
            if (username == null) {
                username = connectionKey.getProviderUserId();
            }
            Collection<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(Role.ROLE_USER.toString()));
            SocialUser socialUser = new SocialUser(username, "SocialUser", authorities);
            ApplicationUser applicationUser = new ApplicationUser();
            applicationUser.setSocialUser(socialUser);
            applicationUser.setConnectionKey(connectionKey);
            applicationUser.setUserProfile(userProfile);
            applicationUser.setImageUrl(imageUrl);
            applicationUser.setProfileUrl(profileUrl);

            return applicationUser;
        }
    }
}
