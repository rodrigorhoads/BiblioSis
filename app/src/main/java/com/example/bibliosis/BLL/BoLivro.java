package com.example.bibliosis.BLL;

import android.content.Context;

import com.example.bibliosis.DAL.LivroHelper;
import com.example.bibliosis.DML.Livro;

public class BoLivro {

    Context context;

    public BoLivro(Context pContext){
        this.context = pContext;
    }

    public long  incluirLivro(Livro livro){

        LivroHelper livroHelper = new LivroHelper(context);
        return livroHelper.incluirLivro(livro);


    }
}
