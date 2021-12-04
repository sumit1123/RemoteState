package com.example.mvvmsample.ui;


import com.example.mvvmsample.repo.model.Data;

import retrofit2.Response;

public interface IRouteNavigator {

    void onSucess(Response<Data> response);

    void onFailure();
}
