package com.example.eduardopalacios.pokedex.ui.showCharacters;

import android.app.Application;

import com.example.eduardopalacios.pokedex.base.BasePresenter;


public interface CharactersMvpPresenter<V extends CharactersMvpView, I extends CharactersMvpInteractor>
        extends BasePresenter<V,I>{

    void RequestValues();

}
