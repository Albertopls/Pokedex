package com.example.eduardopalacios.pokedex.base;

public interface BasePresenter<V extends BaseView,I extends BaseInteractor> {

    V getView();
    I getInteractor();
    void onAttach(V BaseActivityviews);
}
