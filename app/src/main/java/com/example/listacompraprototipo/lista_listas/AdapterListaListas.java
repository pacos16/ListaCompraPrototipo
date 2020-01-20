package com.example.listacompraprototipo.lista_listas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listacompraprototipo.R;
import com.example.listacompraprototipo.model.ListaCompra;

import java.util.ArrayList;


public class AdapterListaListas extends RecyclerView.Adapter<AdapterListaListas.ListaViewHolder> {

    private Context context;
    private ArrayList<ListaCompra> listas;
    private IListaListener listaListener;

    public AdapterListaListas(Context context, ArrayList<ListaCompra> listas, IListaListener listaListener) {
        this.context = context;
        this.listas = listas;
        this.listaListener=listaListener;
    }

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_lista,parent,false);

        return new ListaViewHolder(v,listaListener);
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
        private IListaListener listaListener;
        public ListaViewHolder(@NonNull View itemView, IListaListener listaListener) {
            super(itemView);
            tvNombreLista= itemView.findViewById(R.id.tvNombreLista);
            tvCantidadProductos= itemView.findViewById(R.id.tvCantidadProductosLista);
            this.listaListener=listaListener;

            itemView.setOnClickListener(this);
        }

        public void bind(int position){
            ListaCompra listaCompra=listas.get(position);
            tvNombreLista.setText(listaCompra.getNombre());
            tvCantidadProductos.setText(String.valueOf(listaCompra.getSize()));
        }

        @Override
        public void onClick(View v) {
            listaListener.onListaSeleccionada(getAdapterPosition());
        }
    }
}
