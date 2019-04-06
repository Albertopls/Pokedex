package com.example.eduardopalacios.pokedex.base;

import android.support.constraint.ConstraintLayout;

public interface BaseView {

    void onLoadErrorConstraint(ConstraintLayout constraintLayout);
    void OnSuccessConection();
    void OnErrorConection();
}
