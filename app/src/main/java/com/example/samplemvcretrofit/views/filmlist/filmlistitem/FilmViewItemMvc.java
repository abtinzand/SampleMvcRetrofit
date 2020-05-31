package com.example.samplemvcretrofit.views.filmlist.filmlistitem;

import com.example.samplemvcretrofit.views.bases.ObservableViewMvc;
import com.example.samplemvcretrofit.model.Film;

public interface FilmViewItemMvc extends ObservableViewMvc<FilmViewItemMvc.Listener> {

    public interface Listener {
        void onFilmClicked(Film film);
    }

    void bindFilm(Film movie);
}
