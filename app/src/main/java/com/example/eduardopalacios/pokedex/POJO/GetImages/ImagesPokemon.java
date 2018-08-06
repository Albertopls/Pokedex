package com.example.eduardopalacios.pokedex.POJO.GetImages;

public class ImagesPokemon {

    String imagen1;
    String imagen2;
    String imagen3;
    String imagen4;

    public ImagesPokemon(String imagen1, String imagen2, String imagen3, String imagen4) {
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;
        this.imagen4 = imagen4;
    }

    public String getImagen1() {
        return imagen1;
    }

    public String getImagen2() {
        return imagen2;
    }

    public String getImagen3() {
        return imagen3;
    }

    public String getImagen4() {
        return imagen4;
    }
}
