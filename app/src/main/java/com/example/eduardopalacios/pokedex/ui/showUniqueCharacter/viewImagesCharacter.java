package com.example.eduardopalacios.pokedex.ui.showUniqueCharacter;

import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.eduardopalacios.pokedex.R;
import com.example.eduardopalacios.pokedex.base.BaseActivity;
import com.example.eduardopalacios.pokedex.data.ResponseCharacters.GetImages.ImagesPokemon;
import com.example.eduardopalacios.pokedex.di.CharacterApplication;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class viewImagesCharacter extends BaseActivity implements CharacterMvpView ,SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.image1)
    ImageView image1;
    @BindView(R.id.image2)
    ImageView image2;
    @BindView(R.id.image3)
    ImageView image3;
    @BindView(R.id.image4)
    ImageView image4;

    @Inject
    CharacterPresenter characterPresenter;
    @BindView(R.id.Constraint_Error_Connection)
    ConstraintLayout constraintErrorConnection;
    @BindView(R.id.lly_images)
    LinearLayout llyImages;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_images_character);
        ButterKnife.bind(this);


        ((CharacterApplication) getApplication()).getComponent().injectPresenterinView(this);

        characterPresenter.RequestValues(this, getApplication(), getIntent().getStringExtra("Name"));

        onLoadErrorConstraint(constraintErrorConnection);

        swipeRefresh.setOnRefreshListener(this);

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showResults(ImagesPokemon pokemon) {

        Glide.with(this).load(pokemon.getImagen1()).placeholder(R.drawable.load).into(image1);
        Glide.with(this).load(pokemon.getImagen2()).placeholder(R.drawable.load).into(image2);
        Glide.with(this).load(pokemon.getImagen3()).placeholder(R.drawable.load).into(image3);
        Glide.with(this).load(pokemon.getImagen4()).placeholder(R.drawable.load).into(image4);

    }

    @Override
    public void OnErrorConection() {
        super.OnErrorConection();

        image1.setVisibility(View.INVISIBLE);
        image2.setVisibility(View.INVISIBLE);
        image3.setVisibility(View.INVISIBLE);
        image4.setVisibility(View.INVISIBLE);
    }

    @Override
    public void OnSuccessConection() {
        super.OnSuccessConection();

        image1.setVisibility(View.VISIBLE);
        image2.setVisibility(View.VISIBLE);
        image3.setVisibility(View.VISIBLE);
        image4.setVisibility(View.VISIBLE);
    }

    @Override
    public void onRefresh() {

        characterPresenter.RequestValues(this, getApplication(), getIntent().getStringExtra("Name"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                swipeRefresh.setRefreshing(false);
            }
        },3000);
    }
}
