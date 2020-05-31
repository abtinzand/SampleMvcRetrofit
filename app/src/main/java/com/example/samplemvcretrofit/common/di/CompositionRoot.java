package com.example.samplemvcretrofit.common.di;

import com.example.samplemvcretrofit.networking.FilmApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot {

    private Retrofit mRetrofit;

    public FilmApi getFilmApi() {
        return getRetrofit().create(FilmApi.class);
    }

    private Retrofit getRetrofit() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl("http://moviesapi.ir")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
