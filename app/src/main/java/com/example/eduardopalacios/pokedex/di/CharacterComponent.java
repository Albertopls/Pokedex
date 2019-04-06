package com.example.eduardopalacios.pokedex.di;


import com.example.eduardopalacios.pokedex.ui.showUniqueCharacter.viewImagesCharacter;
import com.example.eduardopalacios.pokedex.ui.showCharacters.CharactersPresenter;
import com.example.eduardopalacios.pokedex.ui.showCharacters.viewCharacters;
import com.example.eduardopalacios.pokedex.ui.showUniqueCharacter.CharacterPresenter;

import dagger.Component;


@Component(modules ={CharacterModel.class})
public interface CharacterComponent {

    void inject(viewCharacters viewCharacters);


    void injectPresenterinView(viewImagesCharacter imagesCharacter);

    void injectInteractorinPresenter(CharacterPresenter presenter);
}
