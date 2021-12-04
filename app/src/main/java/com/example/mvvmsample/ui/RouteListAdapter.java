package com.example.mvvmsample.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmsample.base.BaseViewHolder;
import com.example.mvvmsample.databinding.AdapterRoutelistBinding;
import com.example.mvvmsample.repo.model.Route;
import com.example.mvvmsample.utils.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class RouteListAdapter extends RecyclerView.Adapter<BaseViewHolder> implements Filterable {

    Context context;
    List<Route> routelist = new ArrayList<>();
    List<Route> filteredroutelist = new ArrayList<>();

    public RouteListAdapter() {

    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterRoutelistBinding adapterRoutelistBinding = AdapterRoutelistBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(adapterRoutelistBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return filteredroutelist.size();
    }

    public void setData(List<Route> data) {
        this.context = context;
        this.routelist = data;
        this.filteredroutelist = data;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filteredroutelist = routelist;
                } else {
                    List<Route> filteredList = new ArrayList<>();
                    for (Route route : routelist) {
                        if (route.getTruckNumber().toLowerCase().startsWith(charString.toLowerCase())) {
                            filteredList.add(route);
                        }
                    }
                    filteredroutelist = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredroutelist;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredroutelist = (ArrayList<Route>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    private class MyViewHolder extends BaseViewHolder implements RouteViewModelListener {
        AdapterRoutelistBinding adapterRoutelistBinding;
        RouteListAdapterViewModel routeViewModel;

        public MyViewHolder(AdapterRoutelistBinding binding) {
            super(binding.getRoot());
            this.adapterRoutelistBinding = binding;

        }

        @SuppressLint("ResourceAsColor")
        @Override
        public void onBind(int position) {
            routeViewModel = new RouteListAdapterViewModel(this);
            adapterRoutelistBinding.tvTruckNumber.setText(" " + filteredroutelist.get(position).getTruckNumber());
            long date_diff = System.currentTimeMillis() - filteredroutelist.get(position).getLastWaypoint().getUpdateTime();
            long daysago = TimeUnit.MILLISECONDS.toDays(date_diff);
            adapterRoutelistBinding.tvLastupdated.setText(daysago + " days ago");
            if (filteredroutelist.get(position).getLastRunningState().getTruckRunningState() == 0) {
                long date_diff1 = System.currentTimeMillis() - filteredroutelist.get(position).getLastWaypoint().getUpdateTime();
                long days = TimeUnit.MILLISECONDS.toDays(date_diff1);
                adapterRoutelistBinding.tvState.setText("Stopped since last " + days + " days ago");
            } else {
                long date_diff2 = filteredroutelist.get(position).getLastWaypoint().getCreateTime() - System.currentTimeMillis();
                long days = TimeUnit.MILLISECONDS.toDays(date_diff2);
                adapterRoutelistBinding.tvState.setText("Running since last " + days + " days ago");
            }
            adapterRoutelistBinding.tvSpeed.setText(" " + filteredroutelist.get(position).getLastWaypoint().getSpeed() + " k/h");

        }

        @Override
        public void onItemClick() {

        }
    }

}

