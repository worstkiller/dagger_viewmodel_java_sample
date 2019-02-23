package com.vikas.dagger.data.remote;

import com.vikas.dagger.data.model.CommentsModel;
import com.vikas.dagger.data.model.PostsToday;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * api interface
 */
public interface WebService {

    /**
     * Get the list of the today posts from the API
     */
    @GET("/v1/posts")
    Observable<PostsToday> getTodayPosts(@Query("day") String day);

    /**
     * get the details for single thread post
     */
    @GET("v1/posts/{id}/comments")
    Observable<CommentsModel> getPostDetails(@Path("id") int id);
}
