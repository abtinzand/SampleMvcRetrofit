package com.example.samplemvcretrofit.views.controllers;

import androidx.appcompat.app.AppCompatActivity;

import com.example.samplemvcretrofit.common.CustomApplication;
import com.example.samplemvcretrofit.common.di.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot controllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if (controllerCompositionRoot == null) {
            controllerCompositionRoot = new ControllerCompositionRoot(
                    ((CustomApplication)getApplication()).getCompositionRoot(),
                    this
            );
        }

        return controllerCompositionRoot;
    }
}
