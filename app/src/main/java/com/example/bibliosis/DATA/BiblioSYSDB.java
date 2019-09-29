package com.example.bibliosis.DATA;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bibliosis.DAL.ClienteDAL;
import com.example.bibliosis.DAL.LivroDAL;
import com.example.bibliosis.R;

public class BiblioSYSDB extends SQLiteOpenHelper {

    private  static  final  int VERSION = 1;
    private Context context;

    public BiblioSYSDB(Context context) {
        super(context, context.getString(R.string.DATABASENAME), null,VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ClienteDAL.createTableClientedb(context.getString(R.string.NOMETABELACLIENTES)));
        db.execSQL(LivroDAL.createTableLivro(context.getString(R.string.NOMETABELALIVRO)));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(ClienteDAL.dropTableCliente(context.getString(R.string.NOMETABELACLIENTES)));
        db.execSQL(LivroDAL.dropTableLivro(context.getString(R.string.NOMETABELALIVRO)));
        this.onCreate(db);

    }
}
