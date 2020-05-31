package com.example.samplemvcretrofit.views.bases;


public interface ObservableViewMvc<LISTENER_TYPE> extends ViewMvc {

    void registerListener(LISTENER_TYPE listener);

    void unregisterListener(LISTENER_TYPE listener);
}
