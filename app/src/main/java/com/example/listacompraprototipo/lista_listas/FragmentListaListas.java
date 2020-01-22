package com.example.listacompraprototipo.lista_listas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listacompraprototipo.lista_compra.ListActivity;
import com.example.listacompraprototipo.R;
import com.example.listacompraprototipo.SQLiteHelper;
import com.example.listacompraprototipo.model.ListaCompra;

import java.util.ArrayList;

public class FragmentListaListas extends Fragment implements IListaListener {
    public static final String POSICION_LISTA="com.pacosignes.posicionlista";
    private ArrayList<ListaCompra> listasCompra;
    private RecyclerView recyclerViewListas;
    private AdapterListaListas adapterListaListas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rv_listas,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SQLiteHelper helper= SQLiteHelper.getInstance(getContext());
        recyclerViewListas=getActivity().findViewById(R.id.rvListas);
        listasCompra=helper.getListas();
        adapterListaListas =new AdapterListaListas(getActivity(),listasCompra,this);
        recyclerViewListas.setAdapter(adapterListaListas);
        LinearLayoutManager layoutManager=new LinearLayoutManager
                (this.getContext(),LinearLayoutManager.VERTICAL,false);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(recyclerViewListas.getContext(),
                layoutManager.getOrientation() );
        recyclerViewListas.addItemDecoration(dividerItemDecoration);


        recyclerViewListas.setLayoutManager(layoutManager);
    }

    @Override
    public void onListaSeleccionada(int posicion) {
        Intent i=new Intent(getContext(), ListActivity.class);
        i.putExtra(POSICION_LISTA,posicion);
        startActivity(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        adapterListaListas.notifyDataSetChanged();
    }
}
