package com.example.mvvmsample;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mvvmsample.base.BaseActivity;
import com.example.mvvmsample.databinding.ActivityRouteBinding;
import com.example.mvvmsample.repo.model.Data;
import com.example.mvvmsample.repo.model.Route;
import com.example.mvvmsample.ui.IRouteNavigator;
import com.example.mvvmsample.ui.RouteListAdapter;
import com.example.mvvmsample.ui.RouteViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;


public class RouteActivity extends BaseActivity<ActivityRouteBinding, RouteViewModel> implements IRouteNavigator, OnMapReadyCallback {

    @Inject
    RouteViewModel routeViewModel;
    ActivityRouteBinding activityRouteBinding;
    @Inject
    RouteListAdapter routeListAdapter;
    List<Route> routedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        routeViewModel.setNavigator(this);
        this.activityRouteBinding = getViewDataBinding();
        routeViewModel.doRouteApiCall();
        activityRouteBinding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (routeListAdapter.getItemCount() > 0) {
                    routeListAdapter.getFilter().filter(charSequence);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        setUp();
    }

    private void setUpMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void setUp() {
        try {
            activityRouteBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
            activityRouteBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
            activityRouteBinding.recyclerView.setAdapter(routeListAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public RouteViewModel getViewModel() {
        return routeViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_route;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onSucess(Response<Data> response) {
        routeListAdapter.setData(response.body().getData());
        this.routedata = response.body().getData();
        setUpMap();
    }

    @Override
    public void onFailure() {
        Toast.makeText(this, "Plesae try again.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toggle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.isChecked()) {
            item.setIcon(R.drawable.ic_baseline_view_list_24);
            item.setChecked(false);
            activityRouteBinding.llList.setVisibility(View.VISIBLE);
            activityRouteBinding.rlMap.setVisibility(View.GONE);
        } else {
            item.setIcon(R.drawable.ic_baseline_map_24);
            item.setChecked(true);
            activityRouteBinding.llList.setVisibility(View.GONE);
            activityRouteBinding.rlMap.setVisibility(View.VISIBLE);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        try {
            for (int i = 0; i < routedata.size(); i++) {
                if (routedata.get(i).getLastRunningState().getTruckRunningState() == 0) {
                    LatLng truck_location = new LatLng(routedata.get(i).getLastWaypoint().getLat(), routedata.get(i).getLastWaypoint().getLng());
                    googleMap.addMarker(new MarkerOptions().position(truck_location).icon(routeViewModel.bitmapFromVector(getApplicationContext(), R.drawable.ic_baseline_location_red)));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(truck_location));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(truck_location, 12.0f));
                } else if (routedata.get(i).getLastRunningState().getTruckRunningState() == 1) {
                    LatLng truck_location = new LatLng(routedata.get(i).getLastWaypoint().getLat(), routedata.get(i).getLastWaypoint().getLng());
                    googleMap.addMarker(new MarkerOptions().position(truck_location).icon(routeViewModel.bitmapFromVector(getApplicationContext(), R.drawable.ic_baseline_location_green)));
                } else if (routedata.get(i).getLastRunningState().getTruckRunningState() == 2) {
                    LatLng truck_location = new LatLng(routedata.get(i).getLastWaypoint().getLat(), routedata.get(i).getLastWaypoint().getLng());
                    googleMap.addMarker(new MarkerOptions().position(truck_location).icon(routeViewModel.bitmapFromVector(getApplicationContext(), R.drawable.ic_baseline_location_yellow)));
                } else {
                    LatLng truck_location = new LatLng(routedata.get(i).getLastWaypoint().getLat(), routedata.get(i).getLastWaypoint().getLng());
                    googleMap.addMarker(new MarkerOptions().position(truck_location).icon(routeViewModel.bitmapFromVector(getApplicationContext(), R.drawable.ic_baseline_location_blue)));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}