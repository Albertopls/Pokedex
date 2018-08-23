package com.example.eduardopalacios.pokedex.ui.showCharacters;

import android.app.Application;

import com.example.eduardopalacios.pokedex.data.networking.ApiHelper.AppApiHelper;
import com.example.eduardopalacios.pokedex.di.CharacterApplication;
import com.example.eduardopalacios.pokedex.data.networking.requests.Observers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters.MiItems;
import com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters.Pokemon;
import com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters.Result;

import io.reactivex.disposables.CompositeDisposable;

public class CharactersPresenter implements CharactersMvpPresenter {

    @Inject
    CharactersInteractor charactersInteractor;
    @Inject
    CompositeDisposable compositeDisposable;

    @Override
    public void RequestValues(final viewCharacters view, Application application) {

        ((CharacterApplication)application).getComponent().injectPresenter(this);

        compositeDisposable.add(AppApiHelper.commonObservable(charactersInteractor.getCharactersPokemon()).

                subscribeWith(new Observers<MiItems>() {
            @Override
            protected void onSuccess(MiItems miItems) {


                int i=0;
                String image;
                List<Pokemon>characters =new ArrayList<>();
                for (Result result:miItems.getResults())
                {
                    i++;
                    image="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+String.valueOf(i)+".png";
                    characters.add(new Pokemon(image,result.getName()));

                }
                view.OnSuccessConection();
                view.showResults(characters);

                compositeDisposable.dispose();

            }

            @Override
            protected void onTypeError(Throwable i) {

                if (i instanceof IOException)
                {
                    view.OnErrorConection();
                }

            }
        }));

    }


}
