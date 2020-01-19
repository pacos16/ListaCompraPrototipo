package com.example.listacompraprototipo.model;

public class Producto {
    private String nombre;
    private Categoria categoria;
    private int img;


    public Producto(String nombre, Categoria categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
        img=0;

    }
    public Producto(Producto p){
        this.nombre=p.nombre;
        this.categoria=p.categoria;
        this.img=p.img;
    }

    public Producto(String nombre, Categoria categoria, int img) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.img = img;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}
