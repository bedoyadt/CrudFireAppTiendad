package com.cesde.crudfirebrtdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cesde.crudfirebrtdb.models.cliente;
import com.google.firebase.firestore.FirebaseFirestore;

public class Main2Activity extends AppCompatActivity {
    private Button btn_main_ingresar,btn_main_productos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        btn_main_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irIngresar();
            }
        });
        btn_main_productos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irProductos();
            }
        });

    }
    private void init(){
        btn_main_ingresar = findViewById(R.id.btn_main_ingresar);
        btn_main_productos = findViewById(R.id.btn_main_productos);
    }
    protected  void irIngresar(){
        Intent ingresar = new Intent(this, MainActivity.class);
        startActivity(ingresar);
    }
    protected  void irProductos(){
        Intent productos = new Intent(this, Main_productos_Activity.class);
        startActivity(productos);
    }

}
