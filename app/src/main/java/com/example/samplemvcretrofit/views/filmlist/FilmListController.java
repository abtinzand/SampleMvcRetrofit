package com.example.samplemvcretrofit.views.filmlist;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samplemvcretrofit.views.toastshelper.ToastHelper;
import com.example.samplemvcretrofit.model.FetchFilmUseCase;
import com.example.samplemvcretrofit.model.Film;

import java.util.List;

public class FilmListController implements FilmViewMvc.Listener, FetchFilmUseCase.Listener {


    private final FetchFilmUseCase fetchFilmUseCase;
    private FilmViewMvc filmViewMvc;
    private final ToastHelper toastHelper;
    private int page = 1;


    public FilmListController(FetchFilmUseCase fetchFilmUseCase, ToastHelper toastHelper) {
        this.fetchFilmUseCase = fetchFilmUseCase;
        this.toastHelper = toastHelper;
    }

    public void bindView(FilmViewMvc filmViewMvc) {
        this.filmViewMvc = filmViewMvc;
    }

    public void onStart() {
        filmViewMvc.registerListener(this);
        fetchFilmUseCase.registerListener(this);

        filmViewMvc.showProgress();
        fetchFilmUseCase.fetchFilmAndNotify(page);
    }


    public void onStop() {
        filmViewMvc.unregisterListener(this);
        fetchFilmUseCase.unregisterListener(this);

    }

    @Override
    public void bindFilms(List<Film> movieList) {
        filmViewMvc.hideProgress();
        filmViewMvc.bindFilms(movieList);
        page++;
    }

    @Override
    public void onFilmClicked(Film film) {
        //Todo Toast
        toastHelper.showUseCaseError(film);
        fetchFilmUseCase.fetchFilmAndNotify(page);
    }

}
