package com.example.bibliosis.Helpers;
import android.widget.Button;
import android.widget.EditText;
import com.example.bibliosis.CadastrarLivro;
import com.example.bibliosis.DML.CategoriaDeLivros;
import com.example.bibliosis.DML.Livro;
import com.example.bibliosis.R;

public class FormularioLivroHelper {


    private Button btnCadastrarLivro;
    private EditText edtIsbn;
    private EditText edtTitulo;
    private EditText edtNrPaginas;
    private EditText edtEditora;
    private EditText edtNrEdicao;

    private EditText edtAutores;
    private EditText edtPalavrasChaves;
    private EditText edtDataPublicacao;

    public FormularioLivroHelper(CadastrarLivro actiity) {


        edtTitulo = (EditText) actiity.findViewById(R.id.Titulo);
        edtIsbn = (EditText) actiity.findViewById(R.id.ISBN);
        edtAutores = (EditText) actiity.findViewById(R.id.edtTxtAutores);
        edtEditora = (EditText) actiity.findViewById(R.id.edtTxtEditora);
        edtNrEdicao = (EditText) actiity.findViewById(R.id.NrEdicao);
        edtNrPaginas=(EditText) actiity.findViewById(R.id.xtNrPageinas);
        edtDataPublicacao = (EditText) actiity.findViewById(R.id.DataPublicacao);
        edtPalavrasChaves = (EditText) actiity.findViewById(R.id.edtTxtPalavraChave);
        btnCadastrarLivro = (Button)actiity.findViewById(R.id.btnCadastrarLivro);
    }

    public Livro preencheLivro(){

        Livro livro = new Livro();

        livro.setAutores(new String[]{edtAutores.getText().toString()});
        livro.setTítulo(edtTitulo.getText().toString());
        livro.setIssbn(edtIsbn.getText().toString());
        livro.setDataPublicacao(edtDataPublicacao.getText().toString());
        CategoriaDeLivros categorialivro = new CategoriaDeLivros();
        categorialivro.setCodigoCategoria(12);
        livro.setCategoriaDeLivro(categorialivro);
        livro.setEditora(edtEditora.getText().toString());
        String nrEdicao =  edtNrEdicao.getText().toString();
        livro.setNrEdicao(Integer.parseInt(nrEdicao));
        livro.setNrPaginas(Integer.parseInt(edtNrPaginas.getText().toString()));
        livro.setPalavrasChave(new String[]{edtPalavrasChaves.getText().toString()});

        return  livro;
    }
}
