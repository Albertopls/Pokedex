package com.example.eduardopalacios.pokedex.data.ResponseCharacters.Characters;

public class Pokemon {

    String images;
    String name;

    public Pokemon(String images, String name) {
        this.images = images;
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public String getName() {
        return name;
    }
}
