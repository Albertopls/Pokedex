package com.example.eduardopalacios.pokedex.RestClient;

public interface GetResponse<T> {

    void onSuccess(T t);

    void onError(String error);
}
