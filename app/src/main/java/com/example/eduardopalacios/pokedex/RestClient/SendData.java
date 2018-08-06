package com.example.eduardopalacios.pokedex.RestClient;

import android.util.Log;

import com.example.eduardopalacios.pokedex.MVP.Model;
import com.example.eduardopalacios.pokedex.MVPshowCharacter.ModelImagesCharacter;
import com.example.eduardopalacios.pokedex.POJO.Characters.MiItems;
import com.example.eduardopalacios.pokedex.POJO.Characters.Pokemon;
import com.example.eduardopalacios.pokedex.POJO.Characters.Result;
import com.example.eduardopalacios.pokedex.POJO.GetImages.Example;
import com.example.eduardopalacios.pokedex.POJO.GetImages.ImagesPokemon;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class SendData implements GetResponse{


    Model model;

    ModelImagesCharacter modelImagesCharacter;


    public void  sendPost( Model model){

        this.model=model;
        APIService service=ApiUtils.getAPIService();


        Observable<MiItems> observable=service.savePost(200,0);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observers<MiItems>(this));

    }


    public void sendPost2(ModelImagesCharacter modelImagesCharacter,String name)
    {
        this.modelImagesCharacter=modelImagesCharacter;
        APIService service=ApiUtils.getAPIService();

        Observable<Example> observable2=service.savePost2(name);
        observable2.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observers<Example>(this));
    }


    @Override
    public void onSuccess(Object object) {

        if (object instanceof MiItems)
        {
            List<Pokemon>characters =new ArrayList<>();
            MiItems pokemons=(MiItems)object;
            int i=1;
            String image="";

            for (Result result:pokemons.getResults())
            {
                image="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+String.valueOf(i)+".png";
                characters.add(new Pokemon(image,result.getName()));
                i++;
            }

            model.getVaules(characters);
        }

        if (object instanceof Example)
        {
            Example images=(Example)object;

            ImagesPokemon imagespokemon = new ImagesPokemon(images.getSprites().getBackDefault(),images.getSprites().getBackShiny()
            ,images.getSprites().getFrontDefault(),images.getSprites().getFrontShiny());

            modelImagesCharacter.getVaules(imagespokemon);

        }

    }




    @Override
    public void onError(String error) {

        model.getError(error);

    }


}
