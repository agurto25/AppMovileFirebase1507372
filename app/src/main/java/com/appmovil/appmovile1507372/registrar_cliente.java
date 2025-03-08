package com.appmovil.appmovile1507372;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class registrar_cliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar_cliente);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtDni = findViewById(R.id.txtdnicliente);
        EditText txtApellido = findViewById(R.id.txtApellidoscliente);
        EditText txtNombre = findViewById(R.id.txtNombrecliente);
        EditText txtTelefono = findViewById(R.id.txtTelefonocliente);
        EditText txtCorreo = findViewById(R.id.txtCorreocliente);
        EditText txtDireccion = findViewById(R.id.txtDireccioncliente);

        Button btnregistrarcliente = findViewById(R.id.btnRegistrarcliente);

        String idLogeado = FirebaseAuth.getInstance().getCurrentUser().getUid();

        btnregistrarcliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = txtDni.getText().toString();
                String apellido = txtApellido.getText().toString();
                String nombre = txtNombre.getText().toString();
                String telefono = txtTelefono.getText().toString();
                String correo = txtCorreo.getText().toString();
                String direccion = txtDireccion.getText().toString();

                if (TextUtils.isEmpty(dni)|| TextUtils.isEmpty(apellido)||TextUtils.isEmpty(nombre)||TextUtils.isEmpty(nombre)||TextUtils.isEmpty(telefono)||TextUtils.isEmpty(correo)||TextUtils.isEmpty(direccion)){
                    Toast.makeText(registrar_cliente.this, "Todos los campos son obligatorios",Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseReference dr = FirebaseDatabase.getInstance().getReference();
                    String idCliente = dr.child("Clientes").push().getKey();
                    Map<String,String> client = new HashMap<>();
                    client.put("dni",dni);
                    client.put("apellido", apellido);
                    client.put("nombre", nombre);
                    client.put("telefono", telefono);
                    client.put("correo", correo);
                    client.put("direccion", direccion);

                    dr.child("clientes").child(idLogeado).child(idCliente).setValue(client).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(registrar_cliente.this, "Cliente Registrado Correctamente",Toast.LENGTH_SHORT).show();
                                Intent con2 = new Intent(registrar_cliente.this,lista_clientes.class);
                                startActivity(con2);

                            }else{
                                Toast.makeText(registrar_cliente.this, "Error al Registrarse",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });
    }
}