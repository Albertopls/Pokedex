package com.example.eduardopalacios.pokedex.data.networking.ApiHelper;

import com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters.MiItems;
import com.example.eduardopalacios.pokedex.data.ResponseCharacters.GetImages.Example;

import io.reactivex.Observable;

public interface ApiHelper {

        Observable<MiItems> getCharactersPokemon();

        Observable<Example> getImagesPokemon(String name);


}
