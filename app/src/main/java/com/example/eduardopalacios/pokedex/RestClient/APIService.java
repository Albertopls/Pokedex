package com.example.eduardopalacios.pokedex.RestClient;

import com.example.eduardopalacios.pokedex.POJO.MiItems;
import com.example.eduardopalacios.pokedex.POJO.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("pokemon")
    Call<MiItems> savePost();
}
