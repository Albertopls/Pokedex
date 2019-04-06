package com.example.eduardopalacios.pokedex.PHV;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.eduardopalacios.pokedex.Holders.clickCharacter;
import com.example.eduardopalacios.pokedex.R;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.design_item__recycler)
public class Item {

    @View(R.id.pokemonImage1)
    ImageView imagePokemon;
    @View(R.id.pokemonName1)
    TextView namePokemon;

    private String urlImages;
    private String name;
    Context context;

    public Item(Context context,String urlImages, String name){
        this.context=context;
        this.urlImages=urlImages;
        this.name=name;
    }

    @Resolve
    private void onResolved(){
        Glide.with(context).load(urlImages).into(imagePokemon);
        namePokemon.setText(name);
    }


    @Click(R.id.llcharacter)
    private void onClick(){
        Log.d("namepokemons",namePokemon.getText().toString());
        ((clickCharacter)context).onclickCharacter(namePokemon.getText().toString());


    }


}
