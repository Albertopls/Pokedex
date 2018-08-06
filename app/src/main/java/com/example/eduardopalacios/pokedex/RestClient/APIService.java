package com.example.eduardopalacios.pokedex.RestClient;

import com.example.eduardopalacios.pokedex.POJO.Characters.MiItems;
import com.example.eduardopalacios.pokedex.POJO.GetImages.Example;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {


    @GET("pokemon?&")
    Observable<MiItems> savePost(@Query("limit") int limit, @Query("offset") int offset);


    @GET("pokemon-form/{name}/")
    Observable<Example> savePost2(@Path("name") String name);
}
