package com.example.samplemvcretrofit.views.filmlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samplemvcretrofit.R;
import com.example.samplemvcretrofit.model.FetchFilmUseCase;
import com.example.samplemvcretrofit.networking.FilmApi;
import com.example.samplemvcretrofit.networking.JSONResponse;
import com.example.samplemvcretrofit.views.bases.BaseObservableViewMvc;
import com.example.samplemvcretrofit.views.common.ViewFactory;
import com.example.samplemvcretrofit.model.Film;

import java.util.List;

import retrofit2.Call;

public class FilmViewMvcImp extends BaseObservableViewMvc<FilmViewMvc.Listener> implements
        FilmViewMvc, FilmsAdapter.Listener {


    private RecyclerView recyclerView;
    private FilmsAdapter adapter;
    private LinearLayoutManager linearLayoutManager;


    private ProgressBar progressBar;


    public FilmViewMvcImp(LayoutInflater inflater, ViewGroup parent, ViewFactory viewFactory) {

        setRootView(inflater.inflate(R.layout.layout_main, parent, false));

        recyclerView = findViewById(R.id.recycler);
        progressBar = findViewById(R.id.progress_circular);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new FilmsAdapter(this, viewFactory);
        recyclerView.setAdapter(adapter);

    }






    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }


    @Override
    public void bindFilms(List<Film> movies) {
        adapter.bindFilms(movies);
    }

    @Override
    public void onFilmClicked(Film film) {
        for (Listener listener : getListeners()) {
            listener.onFilmClicked(film);
        }
    }
}
