package com.example.eduardopalacios.pokedex.utils;

import com.example.eduardopalacios.pokedex.data.networking.requests.APIService;
import com.example.eduardopalacios.pokedex.data.networking.requests.RetrofitClient;

public class NetWorkingUtils {


    public static final String BASE_URL = "https://pokeapi.co/api/v2/";


        public static APIService getAPIService() {

            return RetrofitClient.getClient(BASE_URL).create(APIService.class);
        }

}
