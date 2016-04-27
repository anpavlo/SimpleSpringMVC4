package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.*;
import org.springframework.stereotype.Service;
import service.FacebookService;
import social.FacebookFriend;
import social.InvitableFriendsOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacebookServiceImpl implements FacebookService {
    @Autowired
    private Facebook facebook;

    @Autowired
    private InvitableFriendsOperations invitableFriendsOperations;

    @Override
    public List<FacebookFriend> getAllFriends() {

        List<FacebookFriend> facebookFriends = new ArrayList<>();

        FriendOperations friends = facebook.friendOperations();
        PagedList<User> usersPage = friends.getFriendProfiles();
        while (usersPage.size() > 0) {
            facebookFriends.addAll(usersPage.stream().
                    map(FacebookFriend::from).
                    collect(Collectors.toList())
            );
            usersPage = friends.getFriendProfiles(usersPage.getNextPage());
        }

        PagedList<UserInvitableFriend> invitablePage = invitableFriendsOperations.getInvitableFriends();
        do {
            facebookFriends.addAll(invitablePage.stream()
                    .map(FacebookFriend::from)
                    .collect(Collectors.toList())
            );

            invitablePage = invitableFriendsOperations.getInvitableFriends(invitablePage.getNextPage());
        } while (invitablePage != null);

        return facebookFriends;
    }


}
