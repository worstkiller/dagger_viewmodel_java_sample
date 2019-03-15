package com.vikas.dagger.ui.home;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.vikas.dagger.data.model.PostsToday;
import com.vikas.dagger.data.remote.WebServiceImpl;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import io.reactivex.observers.DisposableObserver;

/**
 * view model for home screen aka presenter for home screen with more power
 */
public class HomeViewModel extends AndroidViewModel {

    private String TAG = HomeViewModel.class.getSimpleName();
    private WebServiceImpl webService;

    @Inject
    public HomeViewModel(@NonNull Application application, Context localModule, WebServiceImpl webService) {
        super(application);
        this.webService = webService;
        Log.d(TAG, "home view model constructor called");
    }

    void getPosts(String date) {
        webService.getTodayPosts(date, new DisposableObserver<PostsToday>() {
            @Override
            public void onNext(PostsToday postsToday) {
                Log.d(TAG, "on next called with data" + postsToday.getPostArrayList().size());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "on error called");
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "on completed called");
            }
        });
    }
}
