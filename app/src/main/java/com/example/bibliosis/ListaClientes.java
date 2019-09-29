package com.example.bibliosis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bibliosis.BLL.BoCliente;
import com.example.bibliosis.BLL.BoLivro;
import com.example.bibliosis.DML.Cliente;
import com.example.bibliosis.DML.Livro;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);

        BoCliente boCliente = new BoCliente(getBaseContext());

        List<Cliente> listaClientes = boCliente.listarClientes();

        ListView listView = (ListView) findViewById(R.id.ListViewCliente);

        ArrayAdapter<Cliente> arrayAdapter = new ArrayAdapter<Cliente>(this,android.R.layout.simple_list_item_1,listaClientes);

        listView.setAdapter(arrayAdapter);
    }
}
