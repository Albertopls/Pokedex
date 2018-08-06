package com.example.eduardopalacios.pokedex.ID;

import com.example.eduardopalacios.pokedex.MVP.Presenter;
import com.example.eduardopalacios.pokedex.viewCharacters;

import dagger.Component;


@Component(modules ={CharacterModel.class})
public interface CharacterComponent {

    void inject(viewCharacters viewCharacters);

    void injectPresenter(Presenter presenter);
}
