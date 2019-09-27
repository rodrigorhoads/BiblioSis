package BLL;

import DAL.ClienteHelper;
import DML.Cliente;

public class BoCliente {

    public void incluirCliente(Cliente cliente){

        ClienteHelper clienteHelper = new ClienteHelper();
        clienteHelper.incluirCliente(cliente);

    }
}
