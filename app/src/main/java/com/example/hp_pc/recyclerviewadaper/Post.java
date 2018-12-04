package com.example.hp_pc.recyclerviewadaper;

import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable {
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


    protected Post(Parcel in) {
        userProfile = in.readInt();
        userName = in.readString();
        checkIn = in.readString();
        detail = in.readString();
        likeCount = in.readString();
        imagePost = in.readInt();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userProfile);
        dest.writeString(userName);
        dest.writeString(checkIn);
        dest.writeString(detail);
        dest.writeString(likeCount);
        dest.writeInt(imagePost);
    }
}
