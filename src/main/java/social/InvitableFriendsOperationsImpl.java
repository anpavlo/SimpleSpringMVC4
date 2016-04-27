package social;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.social.facebook.api.UserInvitableFriend;
import org.springframework.social.facebook.api.impl.PagedListUtils;
import org.springframework.util.MultiValueMap;

/**
 * Implements paging of invitable friends
 */
public class InvitableFriendsOperationsImpl implements InvitableFriendsOperations {

    private static final String FULL_PROFILE_FIELDS = "id,name,first_name,last_name,middle_name,picture";
    private Facebook facebook;

    public InvitableFriendsOperationsImpl(Facebook facebook) {
        this.facebook = facebook;
    }

    @Override
    public PagedList<UserInvitableFriend> getInvitableFriends() {
        return facebook.friendOperations().getInvitableFriends();
    }

    @Override
    public PagedList<UserInvitableFriend> getInvitableFriends(PagingParameters pagedListParameters) {
        if (pagedListParameters == null) {
            return null;
        }
        MultiValueMap<String, String> parameters = PagedListUtils.getPagingParameters(pagedListParameters);
        parameters.set("fields", FULL_PROFILE_FIELDS);
        return facebook.fetchConnections("me", "invitable_friends", UserInvitableFriend.class, parameters);
    }

}
