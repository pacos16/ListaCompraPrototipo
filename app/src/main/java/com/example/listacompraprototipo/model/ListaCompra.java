package com.example.listacompraprototipo.model;


import java.util.ArrayList;

public class ListaCompra {
    private String nombre;
    private ArrayList<Producto> productos;

    public ListaCompra(String nombre, ArrayList<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }
}
