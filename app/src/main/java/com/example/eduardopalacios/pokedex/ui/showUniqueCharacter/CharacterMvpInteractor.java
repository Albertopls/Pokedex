package com.example.eduardopalacios.pokedex.ui.showUniqueCharacter;

import com.example.eduardopalacios.pokedex.data.ResponseCharacters.GetImages.Example;

import io.reactivex.Observable;

public interface CharacterMvpInteractor {

    Observable<Example> getImagesCharacter(String name);

}
