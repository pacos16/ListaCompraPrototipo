package com.example.listacompraprototipo.lista_compra;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.listacompraprototipo.lista_productos_categorias.ProductCategoryActivity;
import com.example.listacompraprototipo.R;
import com.example.listacompraprototipo.lista_listas.FragmentListaListas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ListActivity extends AppCompatActivity {

    public static final String ID_LISTA= "com.pacosignes.ID_LISTA";
    private Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        FragmentLista fragmentLista=new FragmentLista();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flLista,fragmentLista).commit();
        context=this;

        FloatingActionButton fab=findViewById(R.id.fabOpenProducts);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context, ProductCategoryActivity.class);
                int posicion=getIntent().getIntExtra(FragmentListaListas.POSICION_LISTA,-1);
                i.putExtra(ID_LISTA,posicion);
                startActivity(i);
            }
        });


    }


}
