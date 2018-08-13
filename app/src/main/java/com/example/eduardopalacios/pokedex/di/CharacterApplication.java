package com.example.eduardopalacios.pokedex.di;

import android.app.Application;

public class CharacterApplication extends Application {

    private CharacterComponent characterComponent;

    public CharacterComponent getComponent()
    {

        characterComponent=DaggerCharacterComponent.builder().characterModel(new CharacterModel()).build();
        return characterComponent;

    }
}
