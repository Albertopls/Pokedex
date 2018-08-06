package com.example.eduardopalacios.pokedex.ID;

import android.view.View;

import com.example.eduardopalacios.pokedex.MVP.Presenter;
import com.example.eduardopalacios.pokedex.MVP.Model;
import com.example.eduardopalacios.pokedex.viewCharacters;

import dagger.Module;
import dagger.Provides;

@Module
public class CharacterModel {


    @Provides
    public Presenter presenter()
    {
        return new Presenter();
    }

    @Provides
    public Model modelo()
    {
        return new Model();
    }
    
}
