package social;

import org.springframework.social.facebook.api.User;

import javax.xml.bind.annotation.XmlElement;

public class FacebookUserFriend extends FacebookFriend {
    private User user;

    public FacebookUserFriend() {}

    public FacebookUserFriend(User user) {
        this.user = user;
    }

    @Override
    public String getFirstName() {
        return user.getFirstName();
    }

    @Override
    public String getLastName() {
        return user.getLastName();
    }

    @Override
    public String getMiddleName() {
        return user.getMiddleName();
    }

    @Override
    public String getName() {
        return user.getName();
    }

    @Override
    public String getProfileURL() {
        return user.getLink();
    }

    @Override
    public String getPictureURL() {
        return user.getCover().getSource();
    }
}
