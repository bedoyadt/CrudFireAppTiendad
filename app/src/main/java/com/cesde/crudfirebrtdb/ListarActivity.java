package com.cesde.crudfirebrtdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cesde.crudfirebrtdb.adapters.ClienteAdapter;
import com.cesde.crudfirebrtdb.models.ClienteModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListarActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference referenciaClientes;
    private ListView lv_listar_lista;
    private ClienteModel model;
    private ArrayList<ClienteModel> list;
    private ClienteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        inicializar();

        listarClientes();

        lv_listar_lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                model = (ClienteModel) adapterView.getItemAtPosition(i);
                clickItem(model);
            }
        });
    }

    private void inicializar(){
        database = FirebaseDatabase.getInstance();
        referenciaClientes = database.getReference("productos");
        lv_listar_lista = findViewById(R.id.lv_listar_lista);
        model = new ClienteModel();
        list = new ArrayList<>();
    }

    private void listarClientes(){
        referenciaClientes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                list = new ArrayList<>();
                for (DataSnapshot child : dataSnapshot.getChildren()){
                    model = child.getValue(ClienteModel.class);
                    if(model != null){
                        list.add(model);
                    }
                }
                adapter = new ClienteAdapter(list, ListarActivity.this);
                lv_listar_lista.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(ListarActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void clickItem(ClienteModel model){
        Toast.makeText(this, "Usted presionó a " + model.get_nombre(), Toast.LENGTH_LONG).show();
        String id = model.get_id();
        irDetalle(id);
    }

    private void irDetalle(String id){
        Intent detalle = new Intent(this, DetalleActivity.class);
        detalle.putExtra("id", id);
        startActivity(detalle);
    }
}
