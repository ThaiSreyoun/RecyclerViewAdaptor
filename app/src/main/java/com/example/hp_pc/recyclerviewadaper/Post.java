package com.example.hp_pc.recyclerviewadaper;

public class Post  {
    int userProfile;
    String userName;
    String  checkIn;
    String  detail;
    String likeCount;
    int imagePost;

    public Post(int userProfile, String userName, String  checkIn, String  detail, String likeCount, int imagePost){
        this.userProfile=userProfile;
        this.userName=userName;
        this.checkIn=checkIn;
        this.detail=detail;
        this.likeCount=likeCount;
        this.imagePost=imagePost;
    }


    public int getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(int userProfile) {
        this.userProfile = userProfile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public int getImagePost() {
        return imagePost;
    }

    public void setImagePost(int imagePost) {
        this.imagePost = imagePost;
    }
}
