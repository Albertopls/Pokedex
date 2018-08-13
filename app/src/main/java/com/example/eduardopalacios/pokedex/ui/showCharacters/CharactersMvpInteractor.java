package com.example.eduardopalacios.pokedex.ui.showCharacters;

import com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters.MiItems;
import io.reactivex.Observable;

public interface CharactersMvpInteractor {

    Observable<MiItems> getCharactersPokemon();
}
