package com.example.eduardopalacios.pokedex.ui.showCharacters;

import android.app.Application;

import com.example.eduardopalacios.pokedex.base.BasePresenterImpl;
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

public class CharactersPresenter<V extends CharactersMvpView,I extends CharactersMvpInteractor>
        extends BasePresenterImpl<V,I>implements CharactersMvpPresenter<V,I> {

    //@Inject
    //CharactersInteractor charactersInteractor;
    //@Inject
    //CompositeDisposable compositeDisposable;

    @Inject
    public CharactersPresenter(I interactor, CompositeDisposable compositeDisposable) {
        super(interactor, compositeDisposable);
    }

    @Override
    public void RequestValues() {

        //((CharacterApplication)application).getComponent().injectPresenter(this);

        getCompositeDisposable().add(AppApiHelper.commonObservable(getInteractor().getCharactersPokemon()).

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
                getView().OnSuccessConection();
                getView().showResults(characters);

                getCompositeDisposable().dispose();

            }

            @Override
            protected void onTypeError(Throwable i) {

                if (i instanceof IOException)
                {
                    getView().OnErrorConection();
                }

            }
        }));

    }


}
