package com.example.mvvmsample.di;

import com.example.mvvmsample.RouteActivity;
import com.example.mvvmsample.ui.RouteActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = RouteActivityModule.class)
    abstract RouteActivity bindSplashActivity();
}
