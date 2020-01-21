package com.example.listacompraprototipo.model;

public class ProductoAux {

    private Producto producto;
    private int cantidad;

    public ProductoAux(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }
}
