package com.vikas.dagger.di.component;

import android.app.Application;

import com.vikas.dagger.base.BaseApplication;
import com.vikas.dagger.di.module.ViewModelModule;
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
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(BaseApplication githubApp);
}
