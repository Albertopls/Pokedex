package com.example.eduardopalacios.pokedex.di;

import com.example.eduardopalacios.pokedex.ui.showCharacters.CharactersInteractor;
import com.example.eduardopalacios.pokedex.ui.showCharacters.CharactersPresenter;
import com.example.eduardopalacios.pokedex.ui.showUniqueCharacter.CharacterInteractor;
import com.example.eduardopalacios.pokedex.ui.showUniqueCharacter.CharacterPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class CharacterModel {


    @Provides
    public CharactersPresenter charactersPresenter()
    {
        return new CharactersPresenter();
    }

    @Provides
    public CharactersInteractor charactersInteractor()
    {
        return new CharactersInteractor();
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
