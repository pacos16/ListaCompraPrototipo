package com.example.listacompraprototipo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listacompraprototipo.model.ListaCompra;

import java.util.ArrayList;


public class AdapterLista extends RecyclerView.Adapter<AdapterLista.ListaViewHolder> {

    private Context context;
    private ArrayList<ListaCompra> listas;

    public AdapterLista(Context context, ArrayList<ListaCompra> listas) {
        this.context = context;
        this.listas = listas;
    }

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_lista,parent,false);

        return new ListaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return listas.size();
    }

    public class ListaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvNombreLista;
        private TextView tvCantidadProductos;
        public ListaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreLista= itemView.findViewById(R.id.tvNombreLista);
            tvCantidadProductos= itemView.findViewById(R.id.tvCantidadProductosLista);

            itemView.setOnClickListener(this);
        }

        public void bind(int position){
            ListaCompra listaCompra=listas.get(position);
            tvNombreLista.setText(listaCompra.getNombre());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
