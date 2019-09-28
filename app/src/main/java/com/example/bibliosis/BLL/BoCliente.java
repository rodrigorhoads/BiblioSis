package com.example.bibliosis.BLL;

import android.content.Context;

import com.example.bibliosis.DAL.ClienteHelper;
import com.example.bibliosis.DML.Cliente;

public class BoCliente {

    private Context context;

    public  BoCliente(Context pContext){
        this.context = pContext;
    }


    public void incluirCliente(Cliente cliente){

        ClienteHelper clienteHelper = new ClienteHelper(context);
        clienteHelper.incluirCliente(cliente);

    }
}
