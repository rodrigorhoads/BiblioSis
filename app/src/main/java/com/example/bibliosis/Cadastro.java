package com.example.bibliosis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cadastro extends AppCompatActivity {


    Button btnCadastraCliente;
    Button btnCadastrarLivro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCadastraCliente = (Button) findViewById(R.id.btnCadastrarCliente);

        btnCadastrarLivro = (Button) findViewById(R.id.btnCadastrarLivro);


        btnCadastraCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cadastro.this    ,CadastrarCliente.class);
                startActivity(intent);
            }
        });


        btnCadastrarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cadastro.this,CadastrarLivro.class);
                startActivity(intent);
            }
        });

    }
}
