package com.example.eduardopalacios.pokedex.ui.showUniqueCharacter;

import android.app.Application;

public interface CharacterMvpPresenter {

    void RequestValues(viewImagesCharacter viewImagesCharacter, Application application, String name);
}
