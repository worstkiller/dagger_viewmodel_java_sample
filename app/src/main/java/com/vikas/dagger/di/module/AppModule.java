package com.vikas.dagger.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.vikas.dagger.di.ViewModelModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * application level module for dependency
 */
@Module
public abstract class AppModule {

    @Provides
    @Singleton
    static SharedPreferences provideSharedPreferences(@Named("localPref") String pref, Application application) {
        return application.getSharedPreferences(pref, Context.MODE_PRIVATE);
    }


    @Provides
    @Named("localPref")
    static String provideApiToken() {
        return "pref";
    }
}
