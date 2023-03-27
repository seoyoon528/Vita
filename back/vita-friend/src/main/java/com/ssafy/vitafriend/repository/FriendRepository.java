package com.ssafy.vitafriend.repository;

import com.ssafy.vitafriend.dto.*;
import com.ssafy.vitafriend.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {

    // 친구 검색 창에서 닉네임 입력시
    @Query(value = "SELECT DISTINCT u.user_id, u.user_nickname, u.user_img, f.friend_status FROM user u " +
            "LEFT OUTER JOIN friend f ON (u.user_id = f.friend_sending_user_id OR u.user_id = f.friend_receiving_user_id) " +
            "AND (f.friend_sending_user_id = ?1 OR f.friend_receiving_user_id = ?1) AND f.friend_status = 'accepted' " +
            "WHERE u.user_nickname LIKE %?2% "
            , nativeQuery = true
    )
    List<FriendSearchMapping> getFriendSearchListLike(String userId, String userNickname);

    @Query(value = "SELECT DISTINCT u.user_id, u.user_nickname, u.user_img, f.friend_status FROM user u " +
            "LEFT OUTER JOIN friend f ON (u.user_id = f.friend_sending_user_id OR u.user_id = f.friend_receiving_user_id) " +
            "AND (f.friend_sending_user_id = ?1 OR f.friend_receiving_user_id = ?1) AND f.friend_status = 'accepted' "
            , nativeQuery = true
    )
    List<FriendSearchMapping> getFriendSearchList(String userId);

    Friend save(Friend friend);
    List<FriendSendingListDto> findByFriendSendingUser_userIdAndFriendStatus(String sendingUserId, String friendStatus);
    List<FriendReceivingListDto> findByFriendReceivingUser_userIdAndFriendStatus(String receivingUserId, String friendStatus);

    List<FriendSendingListDto> findByFriendSendingUser_userIdAndFriendStatusAndFriendReceivingUser_userNicknameContains(String sendingUserId, String friendStatus, String nickname);
    List<FriendReceivingListDto> findByFriendReceivingUser_userIdAndFriendStatusAndFriendSendingUser_userNicknameContains(String receivingUserId, String friendStatus, String nickname);

    Friend findByFriendSendingUser_userIdAndFriendReceivingUser_userIdAndFriendStatus(String sendingUserId, String receivingUserId, String friendStatus);
    Friend findByFriendSendingUser_userIdAndFriendReceivingUser_userId(String sendingUserId, String receivingUserId);

    Friend findByFriendSendingUser_userNicknameAndFriendReceivingUser_userId(String sendingUserNickname, String receivingUserId);
    Friend findByFriendSendingUser_userIdAndFriendReceivingUser_userNickname(String sendingUserId, String receivingUserNickname);

}
