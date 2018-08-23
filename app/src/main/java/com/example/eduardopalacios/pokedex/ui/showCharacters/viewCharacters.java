package com.example.eduardopalacios.pokedex.ui.showCharacters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.eduardopalacios.pokedex.Holders.AdapterCharacters;
import com.example.eduardopalacios.pokedex.Holders.clickCharacter;
import com.example.eduardopalacios.pokedex.R;
import com.example.eduardopalacios.pokedex.base.BaseActivity;
import com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters.Pokemon;
import com.example.eduardopalacios.pokedex.di.CharacterApplication;
import com.example.eduardopalacios.pokedex.ui.showUniqueCharacter.viewImagesCharacter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class viewCharacters extends BaseActivity implements CharactersMvpView, clickCharacter,SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.rvCharacters)
    RecyclerView recycler;

    @Inject
    CharactersPresenter presenter;

    @BindView(R.id.Constraint_Error_Connection)
    ConstraintLayout constraintErrorConnection;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    viewCharacters viewCharacters =this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        ((CharacterApplication) getApplication()).getComponent().inject(this);

        presenter.RequestValues(viewCharacters, getApplication());

        onLoadErrorConstraint(constraintErrorConnection);

        swipeRefresh.setOnRefreshListener(this);


    }


    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showResults(List<Pokemon> pokemons) {

        AdapterCharacters adapterCharacter = new AdapterCharacters(this, pokemons);

            recycler.setHasFixedSize(true);
            recycler.setLayoutManager(new GridLayoutManager(this, 4));
            recycler.setAdapter(adapterCharacter);


    }

    @Override
    public void onclickCharacter(String name) {

        Intent intent = new Intent(viewCharacters.this, viewImagesCharacter.class);
        intent.putExtra("Name", name);
        startActivity(intent);

    }

    @Override
    public void OnErrorConection() {
        super.OnErrorConection();

        recycler.setVisibility(View.INVISIBLE);




    }

    @Override
    public void OnSuccessConection() {
        super.OnSuccessConection();

        recycler.setVisibility(View.VISIBLE);
    }

    @Override
    public void onRefresh() {

        presenter.RequestValues(viewCharacters, getApplication());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                swipeRefresh.setRefreshing(false);
            }
        },3000);

    }





}
