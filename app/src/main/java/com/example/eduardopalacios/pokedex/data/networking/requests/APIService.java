package com.example.eduardopalacios.pokedex.data.networking.requests;

import com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters.MiItems;
import com.example.eduardopalacios.pokedex.data.ResponseCharacters.GetImages.Example;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {


    @GET("pokemon?&")
    Observable<MiItems> getCharacters(@Query("limit") int limit, @Query("offset") int offset);


    @GET("pokemon-form/{name}/")
    Observable<Example> getImagesCharacter(@Path("name") String name);
}
