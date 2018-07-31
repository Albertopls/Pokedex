package com.example.eduardopalacios.pokedex;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import com.example.eduardopalacios.pokedex.Adapter.AdapterCharacter;
import com.example.eduardopalacios.pokedex.Callback.showResults;
import com.example.eduardopalacios.pokedex.POJO.Pokemon;
import com.example.eduardopalacios.pokedex.RestClient.APIService;
import com.example.eduardopalacios.pokedex.RestClient.ApiUtils;
import com.example.eduardopalacios.pokedex.RestClient.SendData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements showResults {

    AdapterCharacter adapterCharacter;
    LinearLayoutManager llm;
    List<Pokemon> characters;
    @BindView(R.id.recycler)
    RecyclerView recycler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        SendData.sendPost(this);

        llm = new LinearLayoutManager(this);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(llm);

    }

    @Override
    public void showValues(List<Pokemon> pokemon) {
        adapterCharacter = new AdapterCharacter(this,pokemon);
        recycler.setAdapter(adapterCharacter);
    }
}
