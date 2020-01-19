package com.example.listacompraprototipo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listacompraprototipo.model.ListaCompra;

import java.util.ArrayList;

public class FragmentLista extends Fragment {

    private ArrayList<ListaCompra> listasCompra;
    private RecyclerView recyclerViewListas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listas,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SQLiteHelper helper= SQLiteHelper.getInstance(getContext());
        recyclerViewListas=getActivity().findViewById(R.id.rvListas);
        listasCompra=helper.getListas();
        AdapterLista adapterLista=new AdapterLista(getActivity(),listasCompra);
        recyclerViewListas.setAdapter(adapterLista);
        recyclerViewListas.setLayoutManager(new LinearLayoutManager
                (this.getContext(),LinearLayoutManager.VERTICAL,false));
    }
}
