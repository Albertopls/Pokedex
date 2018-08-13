package com.example.eduardopalacios.pokedex.ui.showCharacters;

import com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters.MiItems;
import io.reactivex.Observable;
import com.example.eduardopalacios.pokedex.utils.NetWorkingUtils;

public class CharactersInteractor implements CharactersMvpInteractor {


    @Override
    public Observable<MiItems> getCharactersPokemon() {
        return NetWorkingUtils.getAPIService().getCharacters(200,0);
    }
}
