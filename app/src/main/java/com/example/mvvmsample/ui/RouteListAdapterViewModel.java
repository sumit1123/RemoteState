package com.example.mvvmsample.ui;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RouteListAdapterViewModel {

    RouteViewModelListener codViewModelListener;

    RouteListAdapterViewModel(RouteViewModelListener codViewModelListener) {
        this.codViewModelListener = codViewModelListener;
    }

    public void onItemClick() {
        codViewModelListener.onItemClick();
    }

    public String getDate(long milliSeconds, String dateFormat)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
}
