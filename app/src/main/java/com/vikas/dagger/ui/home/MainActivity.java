package com.vikas.dagger.ui.home;

import android.os.Bundle;

import com.vikas.dagger.R;
import com.vikas.dagger.base.BaseActivity;
import com.vikas.dagger.utils.Utility;

import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends BaseActivity {

    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeViewModel = ViewModelProviders.of(this, getViewModelFactory()).get(HomeViewModel.class);
        homeViewModel.getPosts(Utility.getDateFormatted());
    }
}
