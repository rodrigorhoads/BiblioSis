package com.example.bibliosis.BLL;

import android.content.Context;

import com.example.bibliosis.DAL.LivroDAL;
import com.example.bibliosis.DML.Livro;

import java.util.ArrayList;

public class BoLivro {

    Context context;

    public BoLivro(){}

    public BoLivro(Context pContext){
        this.context = pContext;
    }

    public void  incluirLivro(Livro livro){

        LivroDAL livroHelper = new LivroDAL(context);

        livroHelper.incluirLivro(livro);


    }

    public ArrayList<Livro> listarLivros() {

        LivroDAL livroHelper = new LivroDAL(context);

        ArrayList<Livro> listaLivros = livroHelper.listarLivros();

        return listaLivros;

    }
}
