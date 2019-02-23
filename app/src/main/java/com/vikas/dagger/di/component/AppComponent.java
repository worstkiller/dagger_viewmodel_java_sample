package com.vikas.dagger.di.component;

import android.app.Application;

import com.vikas.dagger.base.MyApplication;
import com.vikas.dagger.di.ViewModelModule;
import com.vikas.dagger.di.module.ActivityBindingModule;
import com.vikas.dagger.di.module.AppModule;
import com.vikas.dagger.di.module.RepositoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, RepositoryModule.class, ActivityBindingModule.class, ViewModelModule.class})
public interface AppComponent extends AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }

}
