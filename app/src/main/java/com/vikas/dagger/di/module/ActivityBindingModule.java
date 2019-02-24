package com.vikas.dagger.di.module;

import com.vikas.dagger.di.ActivityScoped;
import com.vikas.dagger.di.AppScoped;
import com.vikas.dagger.ui.home.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();
}
