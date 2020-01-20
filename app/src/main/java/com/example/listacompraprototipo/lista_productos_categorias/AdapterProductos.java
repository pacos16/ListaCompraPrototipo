package com.example.listacompraprototipo.lista_productos_categorias;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listacompraprototipo.R;
import com.example.listacompraprototipo.model.Producto;

import java.util.ArrayList;


public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.ProductosViewHolder> {

    private ArrayList<Producto> productos;
    private IProductoListener listener;

    public AdapterProductos(ArrayList<Producto> productos, IProductoListener listener) {
        this.productos = productos;
        this.listener=listener;
    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_producto,parent,false);

        return new ProductosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvNombreProducto;
        private ImageView ivRemove;
        private TextView tvEmojiProducto;
        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreProducto=itemView.findViewById(R.id.tvNombreProd);
            tvEmojiProducto= itemView.findViewById(R.id.tvEmoji);
            ivRemove=itemView.findViewById(R.id.ivRemoveProd);
            itemView.setOnClickListener(this);
        }

        public void bind(int position){
            Producto p= productos.get(position);
            tvNombreProducto.setText(p.getNombre());
            int unicode=p.getCategoria().getImage();
            tvEmojiProducto.setText(new String(Character.toChars(unicode)));

        }

        @Override
        public void onClick(View v) {

            listener.onProductoSelecionado(getAdapterPosition());

        }
    }
}
