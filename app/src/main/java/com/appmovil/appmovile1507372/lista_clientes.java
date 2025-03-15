package com.appmovil.appmovile1507372;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class lista_clientes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_clientes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FloatingActionButton btnregistrarcliente = findViewById(R.id.btnRegistrarCliente);

        String CurrentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        ArrayList<Clientes> listclientes = new ArrayList<>();

        ClientesAdapter adclientes = new ClientesAdapter(listclientes);

        LinearLayoutManager lm = new LinearLayoutManager(this);

        RecyclerView rvclientes = findViewById(R.id.rcClientes);

        rvclientes.setLayoutManager(lm);

        rvclientes.setAdapter(adclientes);

        FirebaseDatabase.getInstance().getReference().child("clientes").child(CurrentUserId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    listclientes.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Clientes cliente = dataSnapshot.getValue(Clientes.class);
                        listclientes.add(cliente);
                        adclientes.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnregistrarcliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conecc = new Intent(lista_clientes.this,registrar_cliente.class);
                startActivity(conecc);
            }
        });
    }
}