package com.vikas.dagger.data.model;

import java.util.ArrayList;

/**
 * comments data model
 */
public class CommentsModel {

    ArrayList<SingleComment> commentArrayList;

    public ArrayList<SingleComment> getCommentArrayList() {
        return commentArrayList;
    }

    public void setCommentArrayList(ArrayList<SingleComment> commentArrayList) {
        this.commentArrayList = commentArrayList;
    }

    static class SingleComment {
        int id;
        String body;
        String created_at;
        User user;
        int votes;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public int getVotes() {
            return votes;
        }

        public void setVotes(int votes) {
            this.votes = votes;
        }
    }

    static class User {
        String name;
        UserProfileImage image_url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public UserProfileImage getImage_url() {
            return image_url;
        }

        public void setImage_url(UserProfileImage image_url) {
            this.image_url = image_url;
        }
    }

    static class UserProfileImage {
        String original;

        public String getOriginal() {
            return original;
        }

        public void setOriginal(String original) {
            this.original = original;
        }
    }
}
