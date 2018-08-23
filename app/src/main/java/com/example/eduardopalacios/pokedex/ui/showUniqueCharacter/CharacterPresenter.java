package com.example.eduardopalacios.pokedex.ui.showUniqueCharacter;

import android.app.Application;
import android.util.Log;

import com.example.eduardopalacios.pokedex.data.ResponseCharacters.GetImages.Example;
import com.example.eduardopalacios.pokedex.data.ResponseCharacters.GetImages.ImagesPokemon;
import com.example.eduardopalacios.pokedex.data.networking.ApiHelper.AppApiHelper;
import com.example.eduardopalacios.pokedex.data.networking.requests.Observers;
import com.example.eduardopalacios.pokedex.di.CharacterApplication;

import java.io.IOException;

import javax.inject.Inject;


public class CharacterPresenter implements CharacterMvpPresenter {


    @Inject
    CharacterInteractor characterInteractor;

    @Override
    public void RequestValues(final viewImagesCharacter viewImagesCharacter, Application application, String name) {

        ((CharacterApplication)application).getComponent().injectInteractorinPresenter(this);

        AppApiHelper.commonObservable(characterInteractor.getImagesCharacter(name))
                .subscribe(new Observers<Example>() {
                    @Override
                    protected void onSuccess(Example example) {


                        ImagesPokemon imagespokemon = new ImagesPokemon(example.getSprites().getBackDefault(),example.getSprites().getBackShiny()
                                ,example.getSprites().getFrontDefault(),example.getSprites().getFrontShiny());

                        viewImagesCharacter.OnSuccessConection();
                        viewImagesCharacter.showResults(imagespokemon);
                    }

                    @Override
                    protected void onTypeError(Throwable i) {

                        i.printStackTrace();
                        if (i instanceof IOException)
                        {
                            viewImagesCharacter.OnErrorConection();
                        }

                    }


                });
    }
}
