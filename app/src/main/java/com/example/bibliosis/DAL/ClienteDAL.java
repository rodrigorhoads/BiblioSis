package com.example.bibliosis.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bibliosis.DATA.BiblioSYSDB;
import com.example.bibliosis.DML.CategoriaLeitor;
import com.example.bibliosis.DML.Cliente;
import com.example.bibliosis.R;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAL  {

    private static String NOMETABELA;

    Context context;

    private static final String NOME = "nome";
    private static final String EMAIL = "email";

    private static final String CELULAR = "celular";

    private static final String CPF = "cpf";


    private static final String DATANASCIMENTO = "dataNascimento";

    private static final String CODCATEGORIACLI = "codCategoria";


    public ClienteDAL(Context context) {
        this.context = context;
        NOMETABELA = context.getString(R.string.NOMETABELACLIENTES);
    }

    public long incluirCliente(Cliente cliente) {

        ContentValues values = new ContentValues();

        values.put(NOME, cliente.getNome());
        values.put(EMAIL, cliente.getEmail());
        values.put(CELULAR, cliente.getCelular());
        values.put(CPF, cliente.getCpf());
        values.put(DATANASCIMENTO, cliente.getDataNascimento().toString());
        values.put(CODCATEGORIACLI, cliente.getCategoriaLeitor().getCodigoCategoria());

        BiblioSYSDB biblioSYSDB = new BiblioSYSDB(context);

        SQLiteDatabase db  = biblioSYSDB.getWritableDatabase();

        Long resultado =  db.insert(NOMETABELA, null, values);
        db.close();

        biblioSYSDB.close();

        return resultado;
    }




    public List<Cliente> listarClientes(){

        BiblioSYSDB biblioSYSDB = new BiblioSYSDB(context);

        SQLiteDatabase db  = biblioSYSDB.getReadableDatabase();

        List<Cliente> listaCliente = new ArrayList<>();

        String query = "SELECT * FROM "+NOMETABELA;

        Cursor cursor = db.rawQuery(query,null);

        while(cursor.moveToNext()){

            Cliente cliente = new Cliente();
            cliente.setNome(cursor.getString(cursor.getColumnIndex(NOME)));
            cliente.setId(cursor.getLong(cursor.getColumnIndex("id")));
            cliente.setCelular(cursor.getString(cursor.getColumnIndex(CELULAR)));
            cliente.setCpf(cursor.getString(cursor.getColumnIndex(CPF)));
            cliente.setDataNascimento( cursor.getString(cursor.getColumnIndex(DATANASCIMENTO)));
            cliente.setEmail(EMAIL);
            CategoriaLeitor categoriaLeitor = new CategoriaLeitor();
            categoriaLeitor.setCodigoCategoria(cursor.getInt(cursor.getColumnIndex(CODCATEGORIACLI)));
            cliente.setCategoriaLeitor(categoriaLeitor);
            listaCliente.add(cliente);
        }
        cursor.close();

        return  listaCliente;

    }

    public static String createTableClientedb(String pNomeTabela){
        Log.i("CRIABANCO","CHAMOU O ONCREATE");

        String ddl = "CREATE TABLE " + pNomeTabela + " (" +
                " id INTEGER PRIMARY KEY autoincrement ," +
                " "+NOME+" TEXT," +
                " "+EMAIL+" TEXT," +
                " "+CELULAR+" TEXT," +
                " "+CPF+" TEXT," +
                " "+DATANASCIMENTO+" TEXT," +
                " "+CODCATEGORIACLI+" INTEGER" +
                   ")";
    return ddl  ;
    }

    public static String dropTableCliente(String pNometabela){

        return "DROP TABLE IF EXISTS "+pNometabela;
    }




}
