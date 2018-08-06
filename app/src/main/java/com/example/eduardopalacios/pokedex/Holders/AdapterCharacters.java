package com.example.eduardopalacios.pokedex.Holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.eduardopalacios.pokedex.POJO.Characters.Pokemon;
import com.example.eduardopalacios.pokedex.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AdapterCharacters extends RecyclerView.Adapter<AdapterCharacters.CharacterViewHolder> {

    Context context;
    List<Pokemon> pokemons;
    clickCharacter clickCharacter;


    public AdapterCharacters(Context context, List<Pokemon> pokemons) {
        Log.d("tag",pokemons.get(0).getImages());
        this.context = context;
        this.pokemons = pokemons;
        clickCharacter =(clickCharacter)context;
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.design_item__recycler, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        final String name=pokemons.get(position).getName();
        Glide.with(context).load(pokemons.get(position).getImages()).placeholder(R.drawable.load).into(holder.pokemonImage1);
        holder.pokemonName1.setText(name);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickCharacter.onclickCharacter(name);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

      public static class CharacterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.pokemonImage1)
        public ImageView pokemonImage1;

        @BindView(R.id.pokemonName1)
        public TextView pokemonName1;

        @BindView(R.id.llcharacter)
        public LinearLayout layout;


         CharacterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
