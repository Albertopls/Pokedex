package com.example.eduardopalacios.pokedex.RestClient;

import com.example.eduardopalacios.pokedex.POJO.MiItems;
import com.example.eduardopalacios.pokedex.POJO.Pokemon;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface APIService {


    @GET("pokemon?&")
    Observable<MiItems> savePost(@Query("limit") int limit, @Query("offset") int offset);
}
