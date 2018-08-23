package com.example.eduardopalacios.pokedex.base;

import android.support.constraint.ConstraintLayout;

interface MvpView {


    void onLoadErrorConstraint(ConstraintLayout constraintLayout);
    void OnSuccessConection();
    void OnErrorConection();

}
