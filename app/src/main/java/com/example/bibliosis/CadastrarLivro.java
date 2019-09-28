package com.example.bibliosis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bibliosis.BLL.BoLivro;
import com.example.bibliosis.DML.Livro;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_livro);


        edtTitulo = (EditText) findViewById(R.id.Titulo);
        edtIsbn = (EditText) findViewById(R.id.ISBN);
        edtAutores = (EditText) findViewById(R.id.edtTxtAutores);
        edtEditora = (EditText) findViewById(R.id.edtTxtEditora);
        edtNrEdicao = (EditText) findViewById(R.id.NrEdicao);
        edtNrPaginas=(EditText) findViewById(R.id.xtNrPageinas);
        edtDataPublicacao = (EditText) findViewById(R.id.DataPublicacao);
        edtPalavrasChaves = (EditText) findViewById(R.id.edtTxtPalavraChave);
        btnCadastrarLivro = (Button)findViewById(R.id.btnCadastrarLivro);

        btnCadastrarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Livro livro = new Livro();
                BoLivro boLivro = new BoLivro(getBaseContext());
                edtAutores.getText().toString();

                livro.setAutores(new String[]{edtAutores.getText().toString()});
                livro.setTítulo(edtTitulo.getText().toString());
                livro.setIssbn(edtIsbn.getText().toString());
                livro.setDataPublicacao(edtDataPublicacao.getText().toString());
                livro.setEditora(edtEditora.getText().toString());
                String nrEdicao =  edtNrEdicao.getText().toString();
                livro.setNrEdicao(Integer.parseInt(nrEdicao));
                livro.setNrPaginas(Integer.parseInt(edtNrPaginas.getText().toString()));
                livro.setPalavrasChave(new String[]{edtPalavrasChaves.getText().toString()});

                long idLIvro = boLivro.incluirLivro(livro);
                if( idLIvro> 0){
                    Toast.makeText(CadastrarLivro.this,"Livro de id "+idLIvro+ " inserido com sucesso.",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
