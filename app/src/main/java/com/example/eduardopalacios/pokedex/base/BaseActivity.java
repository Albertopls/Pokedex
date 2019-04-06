package com.example.eduardopalacios.pokedex.base;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity implements BaseView {


    ConstraintLayout constraintLayout;
    @Override
    public void onLoadErrorConstraint(ConstraintLayout constraintLayout) {

       this.constraintLayout=constraintLayout;

    }

    @Override
    public void OnSuccessConection() {
        constraintLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    public void OnErrorConection() {

        constraintLayout.setVisibility(View.VISIBLE);
        Toast.makeText(getApplicationContext(),"No connection",Toast.LENGTH_SHORT).show();

    }
}
