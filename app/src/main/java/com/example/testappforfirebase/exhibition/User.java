package com.example.testappforfirebase.exhibition;

import java.util.HashMap;

public class User {
    private String ID;
    private String nickname;
    private String email;
    private HashMap<String, Boolean> likedExhibit;
    private HashMap<String, String> followingUser;

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public HashMap<String, Boolean> getLikedExhibit() {
        return likedExhibit;
    }
    public void setLikedExhibit(HashMap<String, Boolean> likedExhibit) {
        this.likedExhibit = likedExhibit;
    }
    public HashMap<String, String> getFollowingUser() {
        return followingUser;
    }
    public void setFollowingUser(HashMap<String, String> followingUser) {
        this.followingUser = followingUser;
    }
}
