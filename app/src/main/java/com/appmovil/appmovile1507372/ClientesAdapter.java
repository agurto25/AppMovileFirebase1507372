package com.appmovil.appmovile1507372;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.view.View;

public class ClientesAdapter extends RecyclerView.Adapter<ClientesAdapter.ViewHolderClientes> {
    @NonNull
    @Override
    public ClientesAdapter.ViewHolderClientes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ClientesAdapter.ViewHolderClientes holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHolderClientes extends RecyclerView.ViewHolder{
        public ViewHolderClientes(@NonNull View itemView){
            super(itemView);
        }
    }
}
