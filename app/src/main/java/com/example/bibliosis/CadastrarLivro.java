package com.example.bibliosis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bibliosis.BLL.BoLivro;
import com.example.bibliosis.DML.Livro;
import com.example.bibliosis.Helpers.FormularioLivroHelper;

public class CadastrarLivro extends AppCompatActivity {

    private Button btnCadastrarLivro;
    private EditText edtIsbn;
    private EditText edtTitulo;
    private EditText edtNrPaginas;
    private EditText edtEditora;
    private EditText edtNrEdicao;

    private EditText edtAutores;
    private EditText edtPalavrasChaves;
    private EditText edtDataPublicacao;
    private FormularioLivroHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_livro);



        btnCadastrarLivro = (Button)findViewById(R.id.btnCadastrarLivro);

        helper = new FormularioLivroHelper(this);

        btnCadastrarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BoLivro boLivro = new BoLivro(getBaseContext());
                Livro livro = helper.preencheLivro();

              boLivro.incluirLivro(livro);

              Intent intent = new Intent(CadastrarLivro.this,ListaLivros.class);
              startActivity(intent);

            }
        });


    }
}
