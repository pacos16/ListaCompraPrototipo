package com.example.listacompraprototipo.model;

public class Categoria {
    private String nombre;
    private int image;

    public Categoria(String nombre){
        this.nombre=nombre;
    }

    public Categoria(String nombre, int image) {
        this.nombre = nombre;
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
