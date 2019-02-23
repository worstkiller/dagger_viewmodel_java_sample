package com.vikas.dagger.data.model;

import java.util.ArrayList;

/**
 * data model for posts
 */
public class PostsToday {

    private ArrayList<SinglePost> postArrayList;

    public ArrayList<SinglePost> getPostArrayList() {
        return postArrayList;
    }

    public void setPostArrayList(ArrayList<SinglePost> postArrayList) {
        this.postArrayList = postArrayList;
    }

    static class SinglePost {
        int comments_count;
        String day;
        int id;
        String name;
        String tagline;
        String slug;
        int votes_count;
        String discussion_url;
        Thumbnail thumbnail;

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTagline() {
            return tagline;
        }

        public void setTagline(String tagline) {
            this.tagline = tagline;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public int getVotes_count() {
            return votes_count;
        }

        public void setVotes_count(int votes_count) {
            this.votes_count = votes_count;
        }

        public String getDiscussion_url() {
            return discussion_url;
        }

        public void setDiscussion_url(String discussion_url) {
            this.discussion_url = discussion_url;
        }

        public Thumbnail getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
        }
    }

    static class Thumbnail {
        String image_url;

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }
    }
}
