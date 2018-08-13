package com.example.eduardopalacios.pokedex.ui.showUniqueCharacter;

import com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters.Pokemon;
import com.example.eduardopalacios.pokedex.data.ResponseCharacters.GetImages.ImagesPokemon;

import java.util.List;

public interface CharacterMvpView {

    void showError(String error);
    void showResults(ImagesPokemon pokemons);
}
