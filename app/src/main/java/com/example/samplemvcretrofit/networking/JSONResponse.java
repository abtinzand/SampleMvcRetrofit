package com.example.samplemvcretrofit.networking;

import com.example.samplemvcretrofit.model.Film;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JSONResponse {

    /*private Film[] data;

    public Film[] getFilms() {
        return data;
    }
*/
    @SerializedName("data")
    private final List<Film> mMovies;

    public JSONResponse(List<Film> films) {
        mMovies = films;
    }

    public List<Film> getFilms() {
        return mMovies;
    }

}
