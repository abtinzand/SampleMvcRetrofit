package com.example.samplemvcretrofit.views.filmlist;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.example.samplemvcretrofit.views.controllers.BaseActivity;


public class MainActivity extends BaseActivity {

    private FilmListController filmListController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FilmViewMvc mFilmViewMvc = getCompositionRoot().getViewFactory().getFilmViewMvc(null);

        filmListController = getCompositionRoot().getFilmListController();
        filmListController.bindView(mFilmViewMvc);


        setContentView(mFilmViewMvc.getRootView());

    }


    @Override
    protected void onStart() {
        super.onStart();
        filmListController.onStart();
    }


    @Override
    protected void onStop() {
        super.onStop();
        filmListController.onStop();
    }
}









