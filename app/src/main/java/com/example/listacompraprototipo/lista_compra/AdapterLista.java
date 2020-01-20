package com.example.listacompraprototipo.lista_compra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listacompraprototipo.R;
import com.example.listacompraprototipo.model.ListaCompra;
import com.example.listacompraprototipo.model.ProductoLista;



public class AdapterLista extends RecyclerView.Adapter<AdapterLista.ProductosListaViewHolder> {
    private ListaCompra listaCompra;

    public AdapterLista(ListaCompra listaCompra){
        this.listaCompra=listaCompra;
    }

    @NonNull
    @Override
    public ProductosListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_producto_lista,parent,false);
        return new ProductosListaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosListaViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return listaCompra.getProductos().size();
    }

    public class ProductosListaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvProductoLista;
        private TextView tvCantidadProductoLista;
        private CheckBox cbComprado;
        private TextView tvEmoji;

        public ProductosListaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductoLista=itemView.findViewById(R.id.tvNombreProdLista);
            tvCantidadProductoLista=itemView.findViewById(R.id.tvCantidadProdLista);
            cbComprado=itemView.findViewById(R.id.cbComprado);
            tvEmoji=itemView.findViewById(R.id.tvEmojiProductoLista);



            itemView.setOnClickListener(this);
        }

        public void bind(int position){
            ProductoLista productoLista=listaCompra.getProductos().get(position);
            tvProductoLista.setText(productoLista.getProducto().getNombre());
            tvCantidadProductoLista.setText(String.valueOf(productoLista.getCantidad()));
            cbComprado.setChecked(productoLista.isComprado());
            tvEmoji.setText(new String(Character.toChars(productoLista.getCategoria().getImage())));
            cbComprado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }

}
