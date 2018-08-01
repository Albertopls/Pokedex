package com.example.eduardopalacios.pokedex.RestClient;

import android.content.Context;
import android.util.Log;

import com.example.eduardopalacios.pokedex.Callback.showResults;
import com.example.eduardopalacios.pokedex.MainActivity;
import com.example.eduardopalacios.pokedex.POJO.MiItems;
import com.example.eduardopalacios.pokedex.POJO.Pokemon;
import com.example.eduardopalacios.pokedex.POJO.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SendData {



    public static void  sendPost(final Context context){

        final showResults showResults=(showResults) context;
        APIService service=ApiUtils.getAPIService();


        service.savePost(200,0).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MiItems>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MiItems miItems) {

                        List<Pokemon> characters=new ArrayList<>();
                        String image="";
                        int i=1;
                        for (Result result:miItems.getResults())
                        {
                            image ="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+String.valueOf(i)+".png";
                            characters.add(new Pokemon(image,result.getName()));
                            Log.d("tag", result.getName());
                            i++;
                        }


                        showResults.showValues(characters);

                    }
                });




    }





}
