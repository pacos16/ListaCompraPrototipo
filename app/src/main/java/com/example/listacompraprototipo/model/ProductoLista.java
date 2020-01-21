package com.example.listacompraprototipo.model;

public class ProductoLista extends Producto {
    private static int currentID;
    private int id;
    private Producto producto;
    private int cantidad;
    private boolean comprado;

    public ProductoLista( int id, Producto producto, int cantidad, boolean comprado) {
        super(producto);
        if(id>=currentID) currentID=id+1;

        this.id = id;
        this.cantidad = cantidad;
        this.comprado = comprado;
    }

    public ProductoLista(Producto producto){
        super(producto);
        id=currentID;
        currentID++;this.producto=producto;
        this.cantidad=1;
        this.comprado=false;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }
}
