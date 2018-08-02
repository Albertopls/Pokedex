package com.example.eduardopalacios.pokedex.MVP;

import android.content.Context;

import com.example.eduardopalacios.pokedex.POJO.Pokemon;
import com.example.eduardopalacios.pokedex.RestClient.SendData;

import java.util.List;

public class Presenter implements MVPCharactersCallback.presenter
{

    MVPCharactersCallback.view view;
    MVPCharactersCallback.Model model;

    public Presenter()
    {
        model= new  Model(this);
    }
    @Override
    public void RequestValues(Context context) {

        view=(MVPCharactersCallback.view)context;
        model.RequestValues(context);
        //SendData.sendPost(context);
    }

    @Override
    public void showResults(List<Pokemon> pokemons) {

        view.showResults(pokemons);
    }
}
