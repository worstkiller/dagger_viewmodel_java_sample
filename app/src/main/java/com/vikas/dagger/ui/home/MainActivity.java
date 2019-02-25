package com.vikas.dagger.ui.home;

import android.os.Bundle;

import com.vikas.dagger.R;
import com.vikas.dagger.utils.Utility;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    private HomeViewModel homeViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel.class);
        homeViewModel.getPosts(Utility.getDateFormatted());
    }
}
