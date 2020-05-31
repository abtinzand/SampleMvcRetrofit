package com.example.samplemvcretrofit.model;

import android.util.Log;

import com.example.samplemvcretrofit.views.bases.BaseObservableViewMvc;
import com.example.samplemvcretrofit.networking.FilmApi;
import com.example.samplemvcretrofit.networking.JSONResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchFilmUseCase extends BaseObservableViewMvc<FetchFilmUseCase.Listener> {

    private final FilmApi mFilmApi;


    public FetchFilmUseCase(FilmApi mFilmApi) {
        this.mFilmApi = mFilmApi;
    }

    public interface Listener {
        void bindFilms(List<Film> movieList);
    }

    public void fetchFilmAndNotify(final int pageNum) {

        mFilmApi.getTops(pageNum).enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                if (response.isSuccessful()) {
                    Log.i("TAG", "Successful: " + response.body());

                    notifySuccess(response.body().getFilms());


                } else {
                    Log.i("TAG", "UnSuccessful: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.i("TAG", "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    public void notifySuccess(List<Film> films) {
        List<Film> movieList = new ArrayList<>(films.size());
        for (Film film : films) {
            movieList.add(new Film(film.getTitle(), film.getPoster(), film.getYear(), film.getImdb_rating()));

        }
        for (Listener listener : getListeners()) {
            listener.bindFilms(movieList);
        }
    }
}
