package com.example.eduardopalacios.pokedex.RestClient;

import android.content.Context;
import android.util.Log;

import com.example.eduardopalacios.pokedex.Callback.showResults;
import com.example.eduardopalacios.pokedex.MVP.MVPCharactersCallback;
import com.example.eduardopalacios.pokedex.POJO.MiItems;
import com.example.eduardopalacios.pokedex.POJO.Pokemon;
import com.example.eduardopalacios.pokedex.POJO.Result;
import com.example.eduardopalacios.pokedex.POJO.sprites.Example;
import com.example.eduardopalacios.pokedex.POJO.sprites.ImagesPokemon;
import com.example.eduardopalacios.pokedex.POJO.sprites.Sprites;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SendData {



    public static void  sendPost(final Context context, final MVPCharactersCallback.Model model){

        final List<Pokemon>characters =new ArrayList<>();

        APIService service=ApiUtils.getAPIService();


        service.savePost(200,0).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MiItems>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MiItems pokemons) {

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
                });



    }

    public static void sendPost2(int number)
    {

        APIService service=ApiUtils.getAPIService();
        final List<ImagesPokemon> imagesPokemons=new ArrayList<>();
        service.savePost2().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Example>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.d("TAG",e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Example example) {

                        imagesPokemons.add(new ImagesPokemon(example.getSprites().getFrontDefault(),example.getSprites().getBackDefault()
                        ,example.getSprites().getFrontShiny(),example.getSprites().getBackShiny()));

                        Log.d("tag","NO HAY VALOR"+imagesPokemons.get(0).getImagen1());
                    }
                });

    }








}
