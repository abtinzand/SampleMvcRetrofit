package com.example.samplemvcretrofit.common;

import android.app.Application;

import com.example.samplemvcretrofit.common.di.CompositionRoot;

public class CustomApplication extends Application {

    private CompositionRoot compositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        compositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return compositionRoot;
    }
}
