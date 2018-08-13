package com.example.eduardopalacios.pokedex.ui.showUniqueCharacter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


import com.example.eduardopalacios.pokedex.data.ResponseCharacters.GetImages.ImagesPokemon;
import com.example.eduardopalacios.pokedex.R;
import com.example.eduardopalacios.pokedex.di.CharacterApplication;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class viewImagesCharacter extends AppCompatActivity implements CharacterMvpView {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_images_character);
        ButterKnife.bind(this);



        ((CharacterApplication)getApplication()).getComponent().injectPresenterinView(this);

        characterPresenter.RequestValues(this,getApplication(),getIntent().getStringExtra("Name"));
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
}
