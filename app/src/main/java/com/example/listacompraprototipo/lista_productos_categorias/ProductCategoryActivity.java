package com.example.listacompraprototipo.lista_productos_categorias;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listacompraprototipo.R;
import com.example.listacompraprototipo.SQLiteHelper;
import com.example.listacompraprototipo.lista_compra.ListActivity;
import com.example.listacompraprototipo.model.ListaCompra;
import com.example.listacompraprototipo.model.Producto;

import java.util.ArrayList;

public class ProductCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        int posicionLista= getIntent().getIntExtra(ListActivity.ID_LISTA,-1);
        ListaCompra listaCompra= SQLiteHelper.getInstance(this).getListas().get(posicionLista);
        ArrayList<Producto> productos=SQLiteHelper.getInstance(this).getProductos();
        FragmentProductos fragmentProductos=new FragmentProductos(productos,listaCompra);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flMainProductos,fragmentProductos).commit();
    }

}
