package com.example.samplemvcretrofit.views.filmlist;


import com.example.samplemvcretrofit.views.bases.ObservableViewMvc;
import com.example.samplemvcretrofit.model.Film;

import java.util.List;

public interface FilmViewMvc extends ObservableViewMvc<FilmViewMvc.Listener> {


    public interface Listener {
        void onFilmClicked(Film film);

    }

    void bindFilms(List<Film> movies);

    void showProgress();

    void hideProgress();
}
