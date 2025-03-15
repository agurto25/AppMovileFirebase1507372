package com.appmovil.appmovile1507372;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClientesAdapter extends RecyclerView.Adapter<ClientesAdapter.ViewHolderClientes> {

    List<Clientes> listaclientes;
    public ClientesAdapter(List<Clientes> clientes){
        this.listaclientes = clientes;
    }

    @NonNull
    @Override
    public ClientesAdapter.ViewHolderClientes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_recycler,parent,false);
        ViewHolderClientes holder = new ViewHolderClientes(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ClientesAdapter.ViewHolderClientes holder, int position) {

        Clientes cliente = listaclientes.get(position);

        holder.apellidos.setText(cliente.getApellido());
        holder.nombres.setText(cliente.getNombre());
        holder.telefono.setText(cliente.getTelefono());
        holder.correo.setText(cliente.getCorreo());
    }

    @Override
    public int getItemCount() {
        return listaclientes.size();
    }
    public class ViewHolderClientes extends RecyclerView.ViewHolder{

        TextView apellidos , nombres , telefono , correo;
        public ViewHolderClientes(@NonNull View itemView){
            super(itemView);
            apellidos = itemView.findViewById(R.id.txtApellidolista);
            nombres = itemView.findViewById(R.id.txtNombrelista);
            telefono = itemView.findViewById(R.id.txtTelefonolista);
            correo = itemView.findViewById(R.id.txtCorreolista);
        }
    }
}
