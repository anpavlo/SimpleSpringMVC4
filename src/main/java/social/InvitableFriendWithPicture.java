package social;

import org.springframework.social.facebook.api.UserInvitableFriend;

public class InvitableFriendWithPicture extends UserInvitableFriend {
    private Picture picture;

    public InvitableFriendWithPicture(String id, String name, String firstName, String middleName, String lastName) {
        super(id, name, firstName, middleName, lastName);
    }

    protected static class Picture {
        private String url;
        private boolean is_silhouette;

        public Picture(String url, boolean is_silhouette) {
            this.url = url;
            this.is_silhouette = is_silhouette;
        }

        public String getUrl() {
            return url;
        }

        public boolean is_silhouette() {
            return is_silhouette;
        }
    }
}
