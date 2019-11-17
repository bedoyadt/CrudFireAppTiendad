package com.cesde.crudfirebrtdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cesde.crudfirebrtdb.models.ClienteModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditarActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference referenciaClientes;
    private TextView tv_editar_nombre;
    private EditText et_editar_nombre, et_editar_tipo, et_editar_valor;
    private Button btn_editar_guardar, btn_editar_listar;
    private ClienteModel model;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        init();

        final String id = getIntent().getStringExtra("id");
        cargarDetalle(id);

        btn_editar_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar(id);
            }
        });
    }

    private void cargarDetalle(String id){

        referenciaClientes.child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                model = dataSnapshot.getValue(ClienteModel.class);
                if(model != null){
                    et_editar_tipo.setText(model.get_nombre());
                    et_editar_nombre.setText(model.get_tipo());
                    et_editar_valor.setText(model.get_valor());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(EditarActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    protected void init(){
        database = FirebaseDatabase.getInstance();
        referenciaClientes = database.getReference("productos");

        tv_editar_nombre = findViewById(R.id.tv_editar_nombre);
        et_editar_tipo = findViewById(R.id.et_editar_tipo);
        et_editar_nombre = findViewById(R.id.et_editar_nombre);
        et_editar_valor = findViewById(R.id.et_editar_valor);
        btn_editar_guardar = findViewById(R.id.btn_editar_guardar);
        btn_editar_listar = findViewById(R.id.btn_editar_listar);
    }

    protected void guardar(String id){
        String tipo_ingresado = et_editar_tipo.getText().toString();
        String nombre_ingresado = et_editar_nombre.getText().toString();
        String valor_ingresado = et_editar_valor.getText().toString();

        model = new ClienteModel(id, tipo_ingresado, nombre_ingresado, valor_ingresado);

        referenciaClientes.child(id).setValue(model);
        Toast.makeText(this, model.toString(), Toast.LENGTH_LONG).show();
        irListar();
    }

    private void irListar(){
        Intent listar = new Intent(this, ListarActivity.class);
        startActivity(listar);
    }
}
