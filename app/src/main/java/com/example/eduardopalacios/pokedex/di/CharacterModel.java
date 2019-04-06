package com.example.eduardopalacios.pokedex.di;

import com.example.eduardopalacios.pokedex.ui.showCharacters.CharactersInteractor;
import com.example.eduardopalacios.pokedex.ui.showCharacters.CharactersMvpInteractor;
import com.example.eduardopalacios.pokedex.ui.showCharacters.CharactersMvpPresenter;
import com.example.eduardopalacios.pokedex.ui.showCharacters.CharactersMvpView;
import com.example.eduardopalacios.pokedex.ui.showCharacters.CharactersPresenter;
import com.example.eduardopalacios.pokedex.ui.showUniqueCharacter.CharacterInteractor;
import com.example.eduardopalacios.pokedex.ui.showUniqueCharacter.CharacterPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class CharacterModel {


   /* @Provides
    public CharactersPresenter charactersPresenter()
    {
        return new CharactersPresenter();
    }*/


    @Provides
    public CharactersMvpPresenter<CharactersMvpView,CharactersMvpInteractor> charactersPresenter
            (CharactersPresenter<CharactersMvpView, CharactersMvpInteractor>presenter){
        return presenter;
    }
    @Provides
    public CharactersMvpInteractor charactersInteractor( CharactersInteractor charactersInteractor)
    {
        return charactersInteractor;
    }


    @Provides
    public CharacterPresenter characterPresenter()
    {
        return new CharacterPresenter();
    }

    @Provides
    public CharacterInteractor characterInteractor()
    {
        return new CharacterInteractor();
    }

    @Provides
    public CompositeDisposable getDisposables() {
        return  new CompositeDisposable();
    }



}
