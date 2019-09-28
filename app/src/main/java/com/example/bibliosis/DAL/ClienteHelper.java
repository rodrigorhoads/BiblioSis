package com.example.bibliosis.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bibliosis.R;

import com.example.bibliosis.DML.Cliente;

public class ClienteHelper extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private String NOMETABELA;

    public ClienteHelper(Context context) {
        super(context, context.getString(R.string.DATABASENAME), null, VERSAO);
        NOMETABELA = context.getString(R.string.NOMETABELACLIENTES);
    }

    public long incluirCliente(Cliente cliente) {

        ContentValues values = new ContentValues();

        values.put("nome", cliente.getNome());
        values.put("email", cliente.getEmail());
        values.put("celular", cliente.getCelular());
        values.put("cpf", cliente.getCpf());
        values.put("dataNascimento", cliente.getDataNascimento().toString());
        values.put("codCategoria", cliente.getCategoriaLeitor().getCodigoCategoria());
        getWritableDatabase().insert(NOMETABELA, null, values);

        String query = "SELECT ROWID from " + NOMETABELA + " order by ROWID DESC limit 1";

        Cursor cursor = getReadableDatabase().rawQuery(query, null);

        if (cursor != null && cursor.moveToFirst()) {
            return cursor.getLong(0);
        }
        return 0;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String ddl = "CREATE TABLE " + NOMETABELA + " (" +
                " id PRIMARY KEY," +
                " nome TEXT," +
                " email TEXT," +
                " celular TEXT," +
                " cpf TEXT UNIQUE NOT NULL," +
                " dataNascimento TEXT," +
                " codCategoria INTEGER" +
                ")";

        db.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String ddl = "DROP TABLE IF EXISTS " + NOMETABELA;
        db.execSQL(ddl);
        this.onCreate(db);
    }
}
