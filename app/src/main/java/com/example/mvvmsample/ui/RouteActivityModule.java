package com.example.mvvmsample.ui;

import android.app.Application;
import dagger.Module;
import dagger.Provides;

@Module
public class RouteActivityModule {

    @Provides
    RouteViewModel provideSplashViewModel(Application application) {
        return new RouteViewModel(application);
    }

    @Provides
    RouteListAdapter provideDrsListAdapter() {
        return new RouteListAdapter();
    }

}
