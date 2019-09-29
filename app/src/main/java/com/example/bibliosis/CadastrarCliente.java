package com.example.bibliosis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bibliosis.BLL.BoCliente;
import com.example.bibliosis.DML.Cliente;
import com.example.bibliosis.Helpers.FormularioClienteHelper;

public class CadastrarCliente extends AppCompatActivity {

    private FormularioClienteHelper helper;
    private Button btnCadastrarCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cliente);

        helper = new FormularioClienteHelper(CadastrarCliente.this);

        btnCadastrarCliente = (Button) findViewById(R.id.btnCadCliente);

        btnCadastrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cliente cliente = helper.preencheCliente();

                BoCliente boCliente = new BoCliente(getBaseContext());

                boCliente.incluirCliente(cliente);

                Intent intent = new Intent(CadastrarCliente.this,ListaClientes.class);
                startActivity(intent);

            }
        });
    }
}
