package com.example.eduardopalacios.pokedex.ui.showCharacters;

import com.example.eduardopalacios.pokedex.base.BaseIntactorImpl;
import com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters.MiItems;
import io.reactivex.Observable;
import com.example.eduardopalacios.pokedex.utils.NetWorkingUtils;

import javax.inject.Inject;

public class CharactersInteractor extends BaseIntactorImpl implements CharactersMvpInteractor {

    @Inject
    public CharactersInteractor() {
    }

    @Override
    public Observable<MiItems> getCharactersPokemon() {
        return NetWorkingUtils.getAPIService().getCharacters(200,0);
    }
}
