package com.example.rxjava.model;

public class Post {



    private String id , name , location , link_img_proflie , link_img_post , description , comments , favorite;


    public Post(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLink_img_proflie() {
        return link_img_proflie;
    }

    public void setLink_img_proflie(String link_img_proflie) {
        this.link_img_proflie = link_img_proflie;
    }

    public String getLink_img_post() {
        return link_img_post;
    }

    public void setLink_img_post(String link_img_post) {
        this.link_img_post = link_img_post;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }
}
