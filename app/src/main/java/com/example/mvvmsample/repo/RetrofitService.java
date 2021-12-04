package com.example.mvvmsample.repo;

import com.example.mvvmsample.repo.model.Data;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("?auth-company=PCH&companyId=33&deactivated=false&key=g2qb5jvucg7j8skpu5q7ria0mu&q-expand=true&q-include=lastRunningState,lastWaypoint")
    Call<Data> doRouteApiCall();

}


