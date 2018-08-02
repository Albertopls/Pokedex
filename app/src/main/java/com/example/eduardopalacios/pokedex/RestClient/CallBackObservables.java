package com.example.eduardopalacios.pokedex.RestClient;

import android.util.Log;

import com.example.eduardopalacios.pokedex.POJO.Pokemon;

import java.util.List;

import rx.Observable;
import rx.Observer;

public class CallBackObservables<T extends List<Pokemon>> implements Observer<T> {



    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }


    @Override
    public void onNext(T t) {

        Log.d("tag",t.get(0).getName());

    }
}
