package com.example.bibliosis.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bibliosis.R;

import java.util.Arrays;

import com.example.bibliosis.DML.Livro;


public class LivroHelper extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private String NOMETABELA;

    public LivroHelper(Context context){

            super(context, context.getString(R.string.DATABASENAME), null, VERSAO);
            NOMETABELA = context.getString(R.string.NOMETABELALIVRO);
    }

    public long incluirLivro(Livro livro) {

        ContentValues values = new ContentValues();

        values.put("titulo", livro.getTítulo());
        values.put("ISBN", livro.getIssbn());
        values.put("codigo", livro.getCodigo());
        values.put("editora", livro.getEditora());
        values.put("nrEdicao", livro.getNrEdicao());
        values.put("autores", Arrays.toString(livro.getAutores()));
        values.put("palavrasChave", Arrays.toString(livro.getPalavrasChave()));

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
                " titulo TEXT," +
                " ISBN TEXT," +
                " codigo TEXT," +
                " editora TEXT," +
                " nrEdicao INTEGER," +
                " codCategoria INTEGER," +
                " autores TEXT," +
                " palavrasChave TEXT" +
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
