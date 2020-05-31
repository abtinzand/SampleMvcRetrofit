package com.example.samplemvcretrofit.views.filmlist;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samplemvcretrofit.views.common.ViewFactory;
import com.example.samplemvcretrofit.model.Film;
import com.example.samplemvcretrofit.views.filmlist.filmlistitem.FilmViewItemMvc;

import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder>
        implements FilmViewItemMvc.Listener {


    public interface Listener {
        void onFilmClicked(Film film);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final FilmViewItemMvc mFilmViewItemMvc;

        public ViewHolder(FilmViewItemMvc mFilmViewItemMvc) {
            super(mFilmViewItemMvc.getRootView());
            this.mFilmViewItemMvc = mFilmViewItemMvc;
        }
    }

   // private final LayoutInflater inflater;
    private final Listener listener;
    private final ViewFactory viewFactory;

    private List<Film> mMovies = new ArrayList<>();

    public FilmsAdapter(Listener listener, ViewFactory viewFactory) {
       // this.inflater = inflater;
        this.listener = listener;
        this.viewFactory = viewFactory;
    }

    public void bindFilms(List<Film> movies) {
        mMovies = new ArrayList<>(movies);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FilmViewItemMvc filmViewItemMvc = viewFactory.getFilmViewItemMvc(parent);
        //new FilmViewItemMvcImp(inflater, parent);
        filmViewItemMvc.registerListener(this);
        return new ViewHolder(filmViewItemMvc);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mFilmViewItemMvc.bindFilm(mMovies.get(position));

    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }


    @Override
    public void onFilmClicked(Film film) {
        listener.onFilmClicked(film);
    }


}