package com.example.listacompraprototipo.model;


import java.util.ArrayList;

public class ListaCompra {
    private static int currentID;
    private int id;
    private String nombre;
    private ArrayList<ProductoLista> productos;

    public ListaCompra(String nombre, ArrayList<ProductoLista> productos) {
        this.id=currentID;
        currentID++;
        this.nombre = nombre;
        this.productos = productos;

    }
    public ListaCompra(int id,String nombre){
        if(id>=currentID){
            currentID=id+1;
        }
        this.id=id;
        this.nombre=nombre;
        productos=new ArrayList<>();
        if(id>=currentID){
            currentID=id+1;
        }
    }

    public boolean addProducto(ProductoLista productoLista){

        return productos.add(productoLista);
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
    public int getSize(){
        return productos.size();
    }

    public ArrayList<ProductoLista> getProductos() {
        return productos;
    }
}
