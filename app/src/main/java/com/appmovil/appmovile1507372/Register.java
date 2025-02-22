package com.appmovil.appmovile1507372;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtApellidoNombre = findViewById(R.id.txtApellidoNombreRegister);
        EditText txtCorreo = findViewById(R.id.txtCorreoRegister);
        EditText txtTelefono = findViewById(R.id.txtTelefonoRegister);
        EditText txtContraseña = findViewById(R.id.txtPassRegister);
        Button btnRegistar = findViewById(R.id.btnRegistrarRegister);
        Button btncancelar = findViewById(R.id.btnCancelarRegister);
        Button btnlimpiar = findViewById(R.id.btnLimpiarRegister);

        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelar = new Intent(Register.this,MainActivity.class);
                startActivity(cancelar);
            }
        });

    }
}