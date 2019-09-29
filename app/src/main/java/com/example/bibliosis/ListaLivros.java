package com.example.bibliosis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bibliosis.BLL.BoLivro;
import com.example.bibliosis.DAL.LivroDAL;
import com.example.bibliosis.DML.Livro;

import java.util.ArrayList;

public class ListaLivros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_livros);

        BoLivro boLivro = new BoLivro(getBaseContext());

        ArrayList<Livro> listarLivros =boLivro.listarLivros();

        ListView listView = (ListView) findViewById(R.id.ListaLivros);

        ArrayAdapter<Livro> arrayAdapter = new ArrayAdapter<Livro>(this,android.R.layout.simple_list_item_1,listarLivros);

        listView.setAdapter(arrayAdapter);


    }
}
