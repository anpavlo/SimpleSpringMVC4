package social;

import org.springframework.social.facebook.api.UserInvitableFriend;

/**
 * Created by roman.golyuk on 15.04.2016.
 */
public class FacebookInvitableFriend extends FacebookFriend {


    private final UserInvitableFriend invitableFriend;

    public FacebookInvitableFriend(UserInvitableFriend invitableFriend) {
        this.invitableFriend = invitableFriend;
    }

    @Override
    public String getFirstName() {
        return invitableFriend.getFirstName();
    }

    @Override
    public String getLastName() {
        return invitableFriend.getLastName();
    }

    @Override
    public String getMiddleName() {
        return invitableFriend.getMiddleName();
    }

    @Override
    public String getName() {
        return invitableFriend.getName();
    }

    @Override
    public String getProfileURL() {
        return null;
    }

    @Override
    public String getPictureURL() {
        return (String) invitableFriend.getExtraData().get("");
    }
}
