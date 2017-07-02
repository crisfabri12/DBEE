package com.example.paulo.mychat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarContacto extends AppCompatActivity {
    EditText nombre;
    EditText apellido;
    EditText email;
    Button editar;
    Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_contacto);
        final DB db = new DB(this);
        nombre = (EditText)findViewById(R.id.input_nombre);
        apellido = (EditText) findViewById(R.id.input_apellido);
        email = (EditText) findViewById(R.id.input_correo);
        editar = (Button) findViewById(R.id.btn_Editar);
        volver = (Button)findViewById(R.id.btn_Regresar);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertarContacto(nombre.getText().toString(),apellido.getText().toString(),email.getText().toString());
                Toast.makeText(AgregarContacto.this,"El Contacto se Inserto",Toast.LENGTH_SHORT).show();
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AgregarContacto.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
}
