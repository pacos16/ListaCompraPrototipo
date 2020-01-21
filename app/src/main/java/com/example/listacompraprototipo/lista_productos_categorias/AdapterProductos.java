package com.example.listacompraprototipo.lista_productos_categorias;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listacompraprototipo.R;
import com.example.listacompraprototipo.model.ProductoAux;

import java.util.ArrayList;


public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.ProductosViewHolder> {

    private ArrayList<ProductoAux> productos;
    private IAddProductoListener listener;
    private IRemoveProductoListener listenerRemove;

    public AdapterProductos(ArrayList<ProductoAux> productos, IAddProductoListener listener,
                            IRemoveProductoListener listenerRemove) {
        this.productos = productos;
        this.listener=listener;
        this.listenerRemove=listenerRemove;
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
        private TextView tvCantidadProducto;
        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreProducto=itemView.findViewById(R.id.tvNombreProd);
            tvEmojiProducto= itemView.findViewById(R.id.tvEmoji);
            ivRemove=itemView.findViewById(R.id.ivRemoveProd);
            tvCantidadProducto=itemView.findViewById(R.id.tvAnyadidoCantidad);
            itemView.setOnClickListener(this);
        }

        public void bind(final int position){
            ProductoAux p= productos.get(position);
            tvNombreProducto.setText(p.getProducto().getNombre());
            int unicode=p.getProducto().getCategoria().getImage();
            tvEmojiProducto.setText(new String(Character.toChars(unicode)));
            if(p.getCantidad()==0) {
                tvCantidadProducto.setVisibility(View.INVISIBLE);
                ivRemove.setVisibility(View.INVISIBLE);
                ivRemove.setEnabled(false);

            }else {
                tvCantidadProducto.setVisibility(View.VISIBLE);
                ivRemove.setVisibility(View.VISIBLE);
                ivRemove.setEnabled(true);
                tvCantidadProducto.setText(String.valueOf(p.getCantidad()));
            }

            ivRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listenerRemove.onRemoveProducto(productos.get(position).getProducto());
                }
            });


        }

        @Override
        public void onClick(View v) {
            ProductoAux producto= productos.get(getAdapterPosition());
            listener.onProductoSelecionado(producto.getProducto());
            producto.setCantidad(productos.get(getAdapterPosition()).getCantidad()+1);
            notifyDataSetChanged();
        }
    }
}
