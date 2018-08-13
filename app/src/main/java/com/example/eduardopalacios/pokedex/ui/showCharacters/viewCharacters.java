package com.example.eduardopalacios.pokedex.ui.showCharacters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.eduardopalacios.pokedex.Holders.AdapterCharacters;
import com.example.eduardopalacios.pokedex.Holders.clickCharacter;
import com.example.eduardopalacios.pokedex.di.CharacterApplication;
import com.example.eduardopalacios.pokedex.ui.showUniqueCharacter.viewImagesCharacter;
import com.example.eduardopalacios.pokedex.R;

import com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters.Pokemon;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class viewCharacters extends AppCompatActivity implements CharactersMvpView,clickCharacter {



    @BindView(R.id.rvCharacters)
    RecyclerView recycler;

    @Inject
    CharactersPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        ((CharacterApplication)getApplication()).getComponent().inject(this);

        presenter.RequestValues(this,getApplication());


    }


    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(),error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showResults(List<Pokemon> pokemons) {

        AdapterCharacters adapterCharacter = new AdapterCharacters(this,pokemons);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new GridLayoutManager(this,4));
        recycler.setAdapter(adapterCharacter);

    }

    @Override
    public void onclickCharacter(String name) {

        Intent intent=new Intent(viewCharacters.this,viewImagesCharacter.class);
        intent.putExtra("Name",name);
        startActivity(intent);

    }

}
