package com.example.eduardopalacios.pokedex.data.networking.requests;

import io.reactivex.observers.DisposableObserver;

public abstract class Observers<T> extends DisposableObserver<T> {


    @Override
    public void onNext(T t) {
        onSuccess(t);

    }

    @Override
    public void onError(Throwable e) {


        onTypeError(e);

    }

    @Override
    public void onComplete() {

    }

    protected abstract void onSuccess(T t);

    protected abstract void onTypeError(Throwable i);
}
