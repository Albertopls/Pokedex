package com.example.eduardopalacios.pokedex.MVPshowCharacter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.eduardopalacios.pokedex.POJO.Characters.Pokemon;
import com.example.eduardopalacios.pokedex.POJO.GetImages.ImagesPokemon;
import com.example.eduardopalacios.pokedex.R;
import com.example.eduardopalacios.pokedex.RestClient.SendData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class viewImagesCharacter extends AppCompatActivity implements CallbackImagesCharacter.view {

    @BindView(R.id.image1)
    ImageView image1;
    @BindView(R.id.image2)
    ImageView image2;
    @BindView(R.id.image3)
    ImageView image3;
    @BindView(R.id.image4)
    ImageView image4;

    PresenterImagesCharacter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_images_character);
        ButterKnife.bind(this);

        presenter=new PresenterImagesCharacter(this);

        presenter.RequestValues(getIntent().getStringExtra("Name"));
        //SendData.sendPost2(1);
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
