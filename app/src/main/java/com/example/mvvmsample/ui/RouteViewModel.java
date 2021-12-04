package com.example.mvvmsample.ui;


import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.example.mvvmsample.base.BaseViewModel;
import com.example.mvvmsample.repo.APIClient;
import com.example.mvvmsample.repo.RetrofitService;
import com.example.mvvmsample.repo.model.Data;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RouteViewModel extends BaseViewModel<IRouteNavigator> {

    RetrofitService apiInterface;

    public RouteViewModel(Application application) {
        super(application);
    }

    public void doRouteApiCall() {
        apiInterface = APIClient.getClient().create(RetrofitService.class);
        Call<Data> call = apiInterface.doRouteApiCall();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.body().getResponseCode().getMessage().equalsIgnoreCase("SUCCESS")) {
                    getNavigator().onSucess(response);
                } else {
                    getNavigator().onFailure();
                }

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                call.cancel();
            }
        });

    }

    public BitmapDescriptor bitmapFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }


}
