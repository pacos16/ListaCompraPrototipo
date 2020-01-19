package com.example.listacompraprototipo.model;

public class Categoria {
    private String nombre;
    private byte[] image;

    public Categoria(String nombre){
        this.nombre=nombre;
    }

    public Categoria(String nombre, byte[] image) {
        this.nombre = nombre;
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
