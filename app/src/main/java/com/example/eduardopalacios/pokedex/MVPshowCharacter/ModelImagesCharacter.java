package com.example.eduardopalacios.pokedex.MVPshowCharacter;

import com.example.eduardopalacios.pokedex.MVP.Presenter;
import com.example.eduardopalacios.pokedex.POJO.GetImages.ImagesPokemon;
import com.example.eduardopalacios.pokedex.RestClient.SendData;

import java.util.List;

public class ModelImagesCharacter implements CallbackImagesCharacter.Model{

    CallbackImagesCharacter.presenter presenter;
    public ModelImagesCharacter(CallbackImagesCharacter.presenter presenter)
    {
        this.presenter=presenter;
    }
    @Override
    public void RequestValues(String name) {

        SendData sendData =new SendData();
        sendData.sendPost2(this,name);

    }

    @Override
    public void getError(String error) {

    }

    @Override
    public void getVaules(ImagesPokemon imagespokemon) {

        presenter.sendResults(imagespokemon);
    }
}
