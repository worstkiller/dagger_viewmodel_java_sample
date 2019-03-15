package com.vikas.dagger.base;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * base activity for
 */
public abstract class BaseActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    public ViewModelProvider.Factory getViewModelFactory() {
        return viewModelFactory;
    }
}