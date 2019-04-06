package com.example.eduardopalacios.pokedex.base;


import io.reactivex.disposables.CompositeDisposable;

public class BasePresenterImpl<V extends BaseView, I extends BaseInteractor> implements BasePresenter<V,I>{

    V view;
    I interactor;
    CompositeDisposable compositeDisposable;

    public BasePresenterImpl(I interactor, CompositeDisposable compositeDisposable) {
        this.interactor = interactor;
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public V getView() {
        return view;
    }

    @Override
    public I getInteractor() {
        return interactor;
    }

    @Override
    public void onAttach(V BaseActivityviews) {
        view=BaseActivityviews;
    }

    public CompositeDisposable getCompositeDisposable(){
        return compositeDisposable;
    }
}
