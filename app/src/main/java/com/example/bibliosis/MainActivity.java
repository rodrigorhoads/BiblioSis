package com.example.bibliosis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnListarClientes;
    Button btnCadastrar;
    Button btnListarLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnListarClientes = (Button)findViewById(R.id.btnListarClientes);
        btnListarLivros = (Button) findViewById(R.id.btnListarLivros);


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Cadastro.class);
                startActivity(intent);
            }
        });

        btnListarLivros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListaLivros.class);
                startActivity(intent);
            }
        });


        btnListarClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListaClientes.class);
                startActivity(intent);
            }
        });

    }
}
