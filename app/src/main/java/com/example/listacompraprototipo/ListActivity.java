package com.example.listacompraprototipo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;



public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        FragmentLista fragmentLista=new FragmentLista();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flLista,fragmentLista).commit();


    }


}
