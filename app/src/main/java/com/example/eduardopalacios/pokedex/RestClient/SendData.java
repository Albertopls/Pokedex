package com.example.eduardopalacios.pokedex.RestClient;

import android.content.Context;
import android.util.Log;

import com.example.eduardopalacios.pokedex.MainActivity;
import com.example.eduardopalacios.pokedex.POJO.MiItems;
import com.example.eduardopalacios.pokedex.POJO.Pokemon;
import com.example.eduardopalacios.pokedex.POJO.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendData {


    public static void  sendPost(Context context){
        final MainActivity mainActivity=(MainActivity)context;

        final List<Pokemon> characters=new ArrayList<>();
        APIService service=ApiUtils.getAPIService();


       service.savePost().enqueue(new Callback<MiItems>() {
           @Override
           public void onResponse(Call<MiItems> call, Response<MiItems> response) {
               int i=0;
              String image="";
               for (Result result:response.body().getResults()){

                   image="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+String.valueOf(i+1)+".png";
                   characters.add(new Pokemon(image,result.getName()));
                   i++;

                   Log.d("tag",image);
               }
               mainActivity.showValues(characters);
           }

           @Override
           public void onFailure(Call<MiItems> call, Throwable t) {

           }
       });
    }
}
