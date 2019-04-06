package com.example.eduardopalacios.pokedex.ui.showCharacters;

import com.example.eduardopalacios.pokedex.base.BaseInteractor;
import com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters.MiItems;
import io.reactivex.Observable;

public interface CharactersMvpInteractor extends BaseInteractor {

    Observable<MiItems> getCharactersPokemon();
}
