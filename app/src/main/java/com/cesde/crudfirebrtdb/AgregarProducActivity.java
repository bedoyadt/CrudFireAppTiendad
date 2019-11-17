package com.cesde.crudfirebrtdb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cesde.crudfirebrtdb.models.ClienteModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AgregarProducActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference referenciaClientes;
    private TextView tv_main_nombre;
    private EditText et_main_nombre, et_main_cedula, et_main_apellido;
    private Button btn_main_guardar, btn_main_listar, btn_main_detalle;
    private ClienteModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_produc);
        init();

        btn_main_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });

        btn_main_listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irListar();
            }
        });



    }

    private void irListar(){
        Intent listar = new Intent(this, ListarActivity.class);
        startActivity(listar);
    }

    private void irDetalle(){
        Intent detalle = new Intent(this, DetalleActivity.class);
        startActivity(detalle);
    }

    protected void guardar(){
        String cedula_ingresado = et_main_cedula.getText().toString();
        String nombre_ingresado = et_main_nombre.getText().toString();
        String apellido_ingresado = et_main_apellido.getText().toString();

        String id = referenciaClientes.push().getKey();
        model = new ClienteModel(id, cedula_ingresado, nombre_ingresado, apellido_ingresado);

        referenciaClientes.child(id).setValue(model)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(AgregarProducActivity.this, "Cliente agregrado con exito", Toast.LENGTH_LONG).show();
                        limpiarCampos();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AgregarProducActivity.this, "Cliente no fue agregrado. "+ e, Toast.LENGTH_LONG).show();
                    }
                });
    }

    protected void init(){
        database = FirebaseDatabase.getInstance();
        referenciaClientes = database.getReference("productos");

        tv_main_nombre = findViewById(R.id.tv_main_nombre);
        et_main_cedula = findViewById(R.id.et_main_cedula);
        et_main_nombre = findViewById(R.id.et_main_nombre);
        et_main_apellido = findViewById(R.id.et_main_apellido);
        btn_main_guardar = findViewById(R.id.btn_main_guardar);
        btn_main_listar = findViewById(R.id.btn_main_listar);
    }

    private void limpiarCampos(){
        et_main_nombre.setText("");
        et_main_cedula.setText("");
        et_main_apellido.setText("");

        et_main_cedula.requestFocus();
    }
}

