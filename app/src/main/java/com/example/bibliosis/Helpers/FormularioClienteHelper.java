package com.example.bibliosis.Helpers;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.example.bibliosis.CadastrarCliente;
import com.example.bibliosis.DML.CategoriaLeitor;
import com.example.bibliosis.DML.Cliente;
import com.example.bibliosis.R;

public class FormularioClienteHelper {

    private EditText edtNome;
    private EditText edtCpf;
    private EditText edtCelular;
    private EditText edtEmail;
    private EditText edtDataNascimento;

    private EditText edtCodigoCategoriaLeitor;


    public FormularioClienteHelper(CadastrarCliente activity){

        edtNome = (EditText) activity.findViewById(R.id.edtNome);
        edtCelular = (EditText) activity.findViewById(R.id.edtCelular);
        edtCpf = (EditText) activity.findViewById(R.id.edtCpf);
        edtEmail = (EditText)activity.findViewById(R.id.edtEmail);
        edtDataNascimento = (EditText) activity.findViewById(R.id.edtDataNascimento);
        edtCodigoCategoriaLeitor = (EditText) activity.findViewById(R.id.edtCategoriaLeitor);
    }


    public Cliente preencheCliente(){

        Cliente cliente  = new Cliente();


        cliente.setNome(edtNome.getText().toString());
        cliente.setCpf(edtCpf.getText().toString());
        cliente.setEmail(edtEmail.getText().toString());
        cliente.setDataNascimento(edtDataNascimento.getText().toString());
        CategoriaLeitor categoriaLeitor = new CategoriaLeitor();
        categoriaLeitor.setCodigoCategoria(Integer.parseInt( edtCodigoCategoriaLeitor.getText().toString()));
        cliente.setCategoriaLeitor(categoriaLeitor);
        cliente.setCelular(edtCelular.getText().toString());

        return cliente;
    }

}
