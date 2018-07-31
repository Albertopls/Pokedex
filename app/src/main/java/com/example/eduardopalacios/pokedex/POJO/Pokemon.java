package com.example.eduardopalacios.pokedex.POJO;

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
