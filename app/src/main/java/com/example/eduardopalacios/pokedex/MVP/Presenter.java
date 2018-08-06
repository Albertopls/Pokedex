package com.example.eduardopalacios.pokedex.MVP;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.eduardopalacios.pokedex.ID.CharacterApplication;
import com.example.eduardopalacios.pokedex.POJO.Characters.Pokemon;
import com.example.eduardopalacios.pokedex.viewCharacters;

import java.util.List;

import javax.inject.Inject;

public class Presenter implements MVPCharactersCallback.presenter
{

    MVPCharactersCallback.view view;
    //MVPCharactersCallback.Model model;

    @Inject
    Model model;


    public Presenter()
    {

    }
    @Override
    public void RequestValues(viewCharacters view ,Application application) {


         this.view=view;
        ((CharacterApplication)application).getComponent().injectPresenter(this);

         model.RequestValues(this);

    }

    @Override
    public void sendError(String error) {
        view.showError(error);
    }

    @Override
    public void sendResults(List<Pokemon> pokemons) {

        //Log.d("tag2",pokemons.get(0).getImages());
        view.showResults(pokemons);
    }
}
