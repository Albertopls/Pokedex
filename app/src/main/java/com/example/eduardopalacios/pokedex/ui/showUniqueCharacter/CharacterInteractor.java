package com.example.eduardopalacios.pokedex.ui.showUniqueCharacter;

import com.example.eduardopalacios.pokedex.data.ResponseCharacters.GetImages.Example;
import com.example.eduardopalacios.pokedex.utils.NetWorkingUtils;

import io.reactivex.Observable;

public class CharacterInteractor implements CharacterMvpInteractor
{

    @Override
    public Observable<Example> getImagesCharacter(String name) {

       return NetWorkingUtils.getAPIService().getImagesCharacter(name);
    }
}
