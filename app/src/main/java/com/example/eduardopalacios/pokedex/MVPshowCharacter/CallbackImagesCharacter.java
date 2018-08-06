package com.example.eduardopalacios.pokedex.MVPshowCharacter;

import android.app.Application;

import com.example.eduardopalacios.pokedex.MVP.Presenter;
import com.example.eduardopalacios.pokedex.POJO.Characters.Pokemon;
import com.example.eduardopalacios.pokedex.POJO.GetImages.ImagesPokemon;
import com.example.eduardopalacios.pokedex.viewCharacters;

import java.util.List;

public class CallbackImagesCharacter {


    interface view{
        void showError(String error);
        void showResults(ImagesPokemon pokemon);
    }

    interface presenter{
        void RequestValues(String name);
        void sendError(String error);
        void sendResults(ImagesPokemon imagespokemon);
    }


    interface Model{

        void RequestValues(String name);
        void getError(String error);
        void getVaules(ImagesPokemon imagespokemon);
    }
}
