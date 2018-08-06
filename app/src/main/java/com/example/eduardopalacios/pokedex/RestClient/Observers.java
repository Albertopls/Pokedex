package com.example.eduardopalacios.pokedex.RestClient;

import io.reactivex.observers.DisposableObserver;

public class Observers<T> extends DisposableObserver<T> {


    SendData sendData;
    public Observers( SendData sendData)
    {
        this.sendData=sendData;
    }
    @Override
    public void onNext(T value) {

        sendData.onSuccess(value);

    }

    @Override
    public void onError(Throwable e) {

        sendData.onError(e.getMessage());

    }

    @Override
    public void onComplete() {

    }
}
