package com.example.samplemvcretrofit.views.toastshelper;

import android.content.Context;
import android.widget.Toast;

import com.example.samplemvcretrofit.model.Film;


public class ToastHelper {

    private final Context mContext;

    public ToastHelper(Context context) {
        mContext = context;
    }

    public void showUseCaseError(Film film) {
        Toast.makeText(mContext, film.getTitle(), Toast.LENGTH_SHORT).show();
    }

}
