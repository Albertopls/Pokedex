package com.example.eduardopalacios.pokedex.MVPshowCharacter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.eduardopalacios.pokedex.R;
import com.example.eduardopalacios.pokedex.RestClient.SendData;

import butterknife.BindView;
import butterknife.ButterKnife;

public class viewImagesCharacter extends AppCompatActivity {

    @BindView(R.id.image1)
    ImageView image1;
    @BindView(R.id.image2)
    ImageView image2;
    @BindView(R.id.image3)
    ImageView image3;
    @BindView(R.id.image4)
    ImageView image4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_images_character);
        ButterKnife.bind(this);


        SendData.sendPost2(1);
    }
}
