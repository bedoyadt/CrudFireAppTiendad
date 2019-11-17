package com.cesde.crudfirebrtdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cesde.crudfirebrtdb.models.ClienteModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetalleActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference referenciaClientes;
    private ClienteModel model;
    private TextView tv_detalle_cedula, tv_detalle_nombre;
    private Button btn_detalle_editar, btn_detalle_eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        inicializar();

        final String id = getIntent().getStringExtra("id");
        cargarDetalle(id);

        btn_detalle_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irEditar(id);
            }
        });

        btn_detalle_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar(id);
            }
        });
    }

    private void eliminar(String id){
        referenciaClientes.child(id).setValue(null);
        irListar();
    }

    private void irListar(){
        Intent listar = new Intent(this, ListarActivity.class);
        startActivity(listar);
    }

    private void irEditar(String id){
        Intent editar = new Intent(this, EditarActivity.class);
        editar.putExtra("id", id);
        startActivity(editar);
    }

    private void inicializar(){
        database = FirebaseDatabase.getInstance();
        referenciaClientes = database.getReference("clientes");
        model = new ClienteModel();
        tv_detalle_cedula = findViewById(R.id.tv_detalle_cedula);
        tv_detalle_nombre = findViewById(R.id.tv_detalle_nombre);
        btn_detalle_editar = findViewById(R.id.btn_detalle_editar);
        btn_detalle_eliminar = findViewById(R.id.btn_detalle_eliminar);
    }

    private void cargarDetalle(String id){

        referenciaClientes.child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                model = dataSnapshot.getValue(ClienteModel.class);
                if(model != null){
                    tv_detalle_cedula.setText(model.get_cedula());
                    String nombreCompleto = model.get_nombre() + ", " + model.get_apellido();
                    tv_detalle_nombre.setText(nombreCompleto);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(DetalleActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
