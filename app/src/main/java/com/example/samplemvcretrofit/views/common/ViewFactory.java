package com.example.samplemvcretrofit.views.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.samplemvcretrofit.views.filmlist.filmlistitem.FilmViewItemMvc;
import com.example.samplemvcretrofit.views.filmlist.filmlistitem.FilmViewItemMvcImp;
import com.example.samplemvcretrofit.views.filmlist.FilmViewMvc;
import com.example.samplemvcretrofit.views.filmlist.FilmViewMvcImp;


public class ViewFactory {

    private final LayoutInflater layoutInflater;

    public ViewFactory(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public FilmViewMvc getFilmViewMvc(@Nullable ViewGroup parent) {

        return new FilmViewMvcImp(layoutInflater, parent, this);
    }

    public FilmViewItemMvc getFilmViewItemMvc(@Nullable ViewGroup parent) {

        return new FilmViewItemMvcImp(layoutInflater, parent);
    }

}
