package com.example.listacompraprototipo.lista_compra;

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

import com.example.listacompraprototipo.R;
import com.example.listacompraprototipo.SQLiteHelper;
import com.example.listacompraprototipo.lista_listas.FragmentListaListas;
import com.example.listacompraprototipo.model.ListaCompra;

public class FragmentLista extends Fragment {
    private ListaCompra listaCompra;
    private RecyclerView rvProductosLista;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rv_productos_lista,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int posicion=getActivity().getIntent().getIntExtra(FragmentListaListas.POSICION_LISTA,-1);
        if(posicion!=-1) {
            listaCompra = SQLiteHelper.getInstance(getContext()).getListas().get(posicion);
        }
        AdapterLista adapterLista=new AdapterLista(listaCompra);
        rvProductosLista=getActivity().findViewById(R.id.rvProductosLista);
        rvProductosLista.setAdapter(adapterLista);
        LinearLayoutManager layoutManager= new LinearLayoutManager(
                getContext(),LinearLayoutManager.VERTICAL,false);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(rvProductosLista.getContext(),
                layoutManager.getOrientation());
        rvProductosLista.addItemDecoration(dividerItemDecoration);
        rvProductosLista.setLayoutManager(layoutManager);
    }
}
