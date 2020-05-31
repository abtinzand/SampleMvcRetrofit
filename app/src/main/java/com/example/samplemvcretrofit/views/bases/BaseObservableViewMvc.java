package com.example.samplemvcretrofit.views.bases;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseObservableViewMvc<LISTENER_TYPE> extends BaseViewMvc
        implements ObservableViewMvc<LISTENER_TYPE> {

    private Set<LISTENER_TYPE> mListeners = new HashSet<>();

    @Override
    public void registerListener(LISTENER_TYPE listener) {
        mListeners.add(listener);
    }

    @Override
    public void unregisterListener(LISTENER_TYPE listener) {
        mListeners.remove(listener);
    }

    protected Set<LISTENER_TYPE> getListeners() {
        return Collections.unmodifiableSet(mListeners);
    }
}
