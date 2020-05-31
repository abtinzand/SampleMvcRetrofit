package com.example.samplemvcretrofit.common.di;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import com.example.samplemvcretrofit.views.toastshelper.ToastHelper;
import com.example.samplemvcretrofit.views.common.ViewFactory;
import com.example.samplemvcretrofit.model.FetchFilmUseCase;
import com.example.samplemvcretrofit.networking.FilmApi;
import com.example.samplemvcretrofit.views.filmlist.FilmListController;

public class ControllerCompositionRoot {

    private final CompositionRoot compositionRoot;
    private final Activity activity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, Activity activity) {

        this.compositionRoot = compositionRoot;
        this.activity = activity;
    }

    private Context getContext() {
        return activity;
    }

    public FilmApi getFilmApi() {
        return compositionRoot.getFilmApi();
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(activity);
    }

    public ViewFactory getViewFactory() {
        return new ViewFactory(getLayoutInflater());
    }

    public FetchFilmUseCase getFetchFilmUseCase() {
        return new FetchFilmUseCase(getFilmApi());
    }

    public FilmListController getFilmListController() {
        return new FilmListController(getFetchFilmUseCase(), getMessagesDisplayer());
    }

    public ToastHelper getMessagesDisplayer() {
        return new ToastHelper(getContext());
    }
}
