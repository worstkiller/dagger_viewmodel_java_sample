package com.vikas.dagger.data.remote;

import com.vikas.dagger.data.model.PostsToday;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * a common class for managing the web service api calls
 */
public class WebServiceImpl {

    private WebService webService;

    @Inject
    public WebServiceImpl(WebService webService) {
        this.webService = webService;
    }

    public void getTodayPosts(String day, DisposableObserver<PostsToday> disposableObserver) {
        webService.getTodayPosts(day)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(disposableObserver);
    }
}
