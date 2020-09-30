package com.zlgspace.mirrorwechat.net.entity.rsp;

import java.util.ArrayList;

/**
 * Created by zl on 2020/9/30.
 */
public class FriendListEntity {

    private ArrayList<UserInfoEntity> friendList = new ArrayList<>();

    public ArrayList<UserInfoEntity> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<UserInfoEntity> friendList) {
        this.friendList = friendList;
    }
}
