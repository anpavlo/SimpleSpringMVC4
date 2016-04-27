package social;

import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.social.facebook.api.UserInvitableFriend;

public interface InvitableFriendsOperations {

    PagedList<UserInvitableFriend> getInvitableFriends();

    PagedList<UserInvitableFriend> getInvitableFriends(PagingParameters pagedListParameters);

}
