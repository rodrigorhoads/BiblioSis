package com.example.bibliosis.BLL;

import android.content.Context;

import com.example.bibliosis.DAL.ClienteDAL;
import com.example.bibliosis.DML.Cliente;
import java.util.List;

public class BoCliente {

    private Context context;

    public  BoCliente(Context pContext){
        this.context = pContext;
    }


    public void incluirCliente(Cliente cliente){

        ClienteDAL clienteHelper = new ClienteDAL(context);

        clienteHelper.incluirCliente(cliente);
    }

    public List<Cliente> listarClientes() {

        ClienteDAL clienteDAL = new ClienteDAL(context);


        List<Cliente> listaClientes = clienteDAL.listarClientes();

        return listaClientes;
    }
}
