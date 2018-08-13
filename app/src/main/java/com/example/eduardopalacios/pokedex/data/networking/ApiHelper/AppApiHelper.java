package com.example.eduardopalacios.pokedex.data.networking.ApiHelper;

import com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters.MiItems;
import com.example.eduardopalacios.pokedex.data.ResponseCharacters.GetImages.Example;
import com.example.eduardopalacios.pokedex.utils.NetWorkingUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AppApiHelper implements ApiHelper{

    public static <T>Observable<T> commonObservable(Observable<T> observable){


        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<MiItems> getCharactersPokemon() {
        return NetWorkingUtils.getAPIService().getCharacters(200,0);
    }

    public Observable<Example> getImagesPokemon(String name) {
        return NetWorkingUtils.getAPIService().getImagesCharacter(name);
    }
}
