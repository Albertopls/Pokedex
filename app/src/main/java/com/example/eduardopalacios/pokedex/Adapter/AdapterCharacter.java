package com.example.eduardopalacios.pokedex.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.eduardopalacios.pokedex.POJO.Pokemon;
import com.example.eduardopalacios.pokedex.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterCharacter extends RecyclerView.Adapter<AdapterCharacter.CharacterViewHolder>{


    List<Pokemon> pokemons;
    Context context;

    public AdapterCharacter(Context context,List<Pokemon> pokemons) {
        this.context=context;
        this.pokemons = pokemons;
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.design_item__recycler,parent,false);
        CharacterViewHolder characterViewHolder=new CharacterViewHolder(view);
        return characterViewHolder;
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        //holder.ivImage

        Glide.with(context).load(pokemons.get(position).getImages()).into(holder.ivImage);

        holder.tvName.setText(pokemons.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public static class  CharacterViewHolder extends RecyclerView.ViewHolder{


        @BindView(R.id.pokemonImage)
        ImageView ivImage;

        @BindView(R.id.pokemonName)
        TextView tvName;

        public CharacterViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
