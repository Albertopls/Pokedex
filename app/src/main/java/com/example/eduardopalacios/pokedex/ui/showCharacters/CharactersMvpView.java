package com.example.eduardopalacios.pokedex.ui.showCharacters;

import java.util.List;

import com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters.Pokemon;

public interface CharactersMvpView {

    void showError(String error);
    void showResults(List<Pokemon> pokemons);
}
