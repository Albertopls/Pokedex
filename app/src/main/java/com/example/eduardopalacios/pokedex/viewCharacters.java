package com.example.eduardopalacios.pokedex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;

import com.example.eduardopalacios.pokedex.Adapter.AdapterCharacter;
import com.example.eduardopalacios.pokedex.Callback.showResults;
import com.example.eduardopalacios.pokedex.MVP.MVPCharactersCallback;
import com.example.eduardopalacios.pokedex.MVP.Presenter;
import com.example.eduardopalacios.pokedex.MVPshowCharacter.viewImagesCharacter;
import com.example.eduardopalacios.pokedex.POJO.Pokemon;
import com.example.eduardopalacios.pokedex.RestClient.APIService;
import com.example.eduardopalacios.pokedex.RestClient.ApiUtils;
import com.example.eduardopalacios.pokedex.RestClient.SendData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class viewCharacters extends AppCompatActivity implements MVPCharactersCallback.view {

    AdapterCharacter adapterCharacter;
    GridLayoutManager llm;
    List<Pokemon> characters;
    @BindView(R.id.recycler)
    RecyclerView recycler;

    MVPCharactersCallback.presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter =new Presenter();
        presenter.RequestValues(this);

        llm = new GridLayoutManager(this,4);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(llm);

    }


    @Override
    public void showResults(List<Pokemon> pokemons) {
        adapterCharacter = new AdapterCharacter(this,pokemons);
        recycler.setAdapter(adapterCharacter);

        Intent intent=new Intent(this, viewImagesCharacter.class);
        startActivity(intent);
    }
}
