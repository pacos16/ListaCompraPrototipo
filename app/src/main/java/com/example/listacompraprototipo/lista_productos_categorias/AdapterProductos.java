package com.example.listacompraprototipo.lista_productos_categorias;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listacompraprototipo.R;
import com.example.listacompraprototipo.model.ProductoLista;

import java.util.ArrayList;


public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.ProductosViewHolder> {

    private ArrayList<ProductoLista> productos;
    private IAddProductoListener listener;
    private IRemoveProductoListener listenerRemove;

    public AdapterProductos(ArrayList<ProductoLista> productos, IAddProductoListener listener,
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
            ProductoLista p= productos.get(position);
            tvNombreProducto.setText(p.getNombre());
            int unicode=p.getCategoria().getImage();
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
                    if(productos.get(position).getCantidad()>0) {
                        listenerRemove.onRemoveProducto(productos.get(position));
                    }else {
                        ivRemove.setEnabled(false);
                        ivRemove.setVisibility(View.INVISIBLE);
                    }
                    notifyDataSetChanged();
                }
            });


        }

        @Override
        public void onClick(View v) {
            ProductoLista producto= productos.get(getAdapterPosition());
            listener.onProductoSelecionado(producto);
            producto.setCantidad(productos.get(getAdapterPosition()).getCantidad()+1);
            notifyDataSetChanged();
        }
    }
}
