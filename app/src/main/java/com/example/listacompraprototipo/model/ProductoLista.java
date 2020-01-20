package com.example.listacompraprototipo.model;

public class ProductoLista extends Producto {

    private int id;
    private Producto producto;
    private int cantidad;
    private boolean comprado;

    public ProductoLista( int id, Producto producto, int cantidad, boolean comprado) {
        super(producto);
        this.id = id;
        this.producto=producto;
        this.cantidad = cantidad;
        this.comprado = comprado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
