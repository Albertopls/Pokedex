package com.example.eduardopalacios.pokedex.RestClient;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://pokeapi.co/api/v2/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

}
