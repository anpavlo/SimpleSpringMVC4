package social;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class FacebookFriends {
    @XmlElement(name = "friend")
    private List<FacebookFriend> friendList;

    public FacebookFriends() {}

    public FacebookFriends(List<FacebookFriend> friendList) {
        this.friendList = friendList;
    }
}
