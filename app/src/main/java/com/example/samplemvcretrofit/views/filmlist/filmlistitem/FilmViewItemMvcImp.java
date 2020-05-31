package com.example.samplemvcretrofit.views.filmlist.filmlistitem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.samplemvcretrofit.R;
import com.example.samplemvcretrofit.views.bases.BaseObservableViewMvc;
import com.example.samplemvcretrofit.model.Film;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

public class FilmViewItemMvcImp extends BaseObservableViewMvc<FilmViewItemMvc.Listener>
        implements FilmViewItemMvc {


    private final TextView txtTitle, txtRelease, txtPopularity;
    private final ImageView imgPoster;

    private Film movie;

    public FilmViewItemMvcImp(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_row, parent, false));


        txtTitle = findViewById(R.id.title);
        txtRelease = findViewById(R.id.release_data);
        txtPopularity = findViewById(R.id.popularity);
        imgPoster = findViewById(R.id.movie_image);

        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()) {
                    listener.onFilmClicked(movie);
                }
            }
        });

    }

    @Override
    public void bindFilm(Film movie) {
        this.movie = movie;
        txtTitle.setText(movie.getTitle());
        txtRelease.setText(movie.getYear());
        txtPopularity.setText(movie.getImdb_rating());

        Picasso
                .get()
                .load(movie.getPoster())
                .centerInside()
                .fit()
                .purgeable()
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(imgPoster);
    }
}
