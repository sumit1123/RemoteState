package com.example.mvvmsample.base;

import android.app.Application;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import java.lang.ref.WeakReference;
import io.reactivex.disposables.CompositeDisposable;


public abstract class BaseViewModel<N> extends AndroidViewModel {

    private WeakReference<N> mNavigator;
    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);
    private final CompositeDisposable mCompositeDisposable;

    public BaseViewModel(Application application) {
        super(application);
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public N getNavigator() {
        return mNavigator.get();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

}
