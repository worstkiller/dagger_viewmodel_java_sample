package com.vikas.dagger.base;

import android.app.Activity;
import android.app.Application;

import com.vikas.dagger.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * application level initialization for dagger components
 */
public class BaseApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().application(this).build().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}