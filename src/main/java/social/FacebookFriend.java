package social;

import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.UserInvitableFriend;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name", "firstName", "lastName", "middleName", "profileURL"})
public abstract class FacebookFriend {

    @XmlElement
    public abstract String getName();

    @XmlElement
    public abstract String getFirstName();

    @XmlElement
    public abstract String getLastName();

    @XmlElement
    public abstract String getMiddleName();

    @XmlElement
    public abstract String getProfileURL();

    public abstract String getPictureURL();

    public static FacebookFriend from(User user) {
        return new FacebookUserFriend(user);
    }

    public static FacebookFriend from(UserInvitableFriend userInvitableFriend) {
        return new FacebookInvitableFriend(userInvitableFriend);
    }
}
