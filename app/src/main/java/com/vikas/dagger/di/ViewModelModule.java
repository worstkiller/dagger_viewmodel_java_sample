package com.vikas.dagger.di;

import com.vikas.dagger.ui.home.HomeViewModel;
import com.vikas.dagger.viewmodel.HomeViewModelFactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    abstract ViewModel bindViewModel(HomeViewModel userViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(HomeViewModelFactory factory);
}
