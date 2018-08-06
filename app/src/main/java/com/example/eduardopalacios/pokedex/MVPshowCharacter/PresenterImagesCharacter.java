package com.example.eduardopalacios.pokedex.MVPshowCharacter;

import com.example.eduardopalacios.pokedex.POJO.GetImages.ImagesPokemon;

import java.util.List;

public class PresenterImagesCharacter implements CallbackImagesCharacter.presenter {

    CallbackImagesCharacter.view view;
    CallbackImagesCharacter.Model model;

    public PresenterImagesCharacter(CallbackImagesCharacter.view view)
    {
        this.view=view;
    }
    @Override
    public void RequestValues(String name) {
        model=new ModelImagesCharacter(this);

        model.RequestValues(name);
    }

    @Override
    public void sendError(String error) {

    }

    @Override
    public void sendResults(ImagesPokemon imagespokemon) {

        view.showResults(imagespokemon);
    }
}
