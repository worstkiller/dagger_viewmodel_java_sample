package com.vikas.dagger.base;

import android.app.Application;

import com.vikas.dagger.di.component.AppComponent;
import com.vikas.dagger.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * application level initialization for dagger components
 */
public class MyApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
