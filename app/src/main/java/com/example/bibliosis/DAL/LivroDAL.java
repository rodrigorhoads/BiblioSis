package com.example.bibliosis.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bibliosis.DATA.BiblioSYSDB;
import com.example.bibliosis.R;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.bibliosis.DML.Livro;


public class LivroDAL {

    private Context context;
    private static final String CODIGOCATEGORIA = "codigoCategoria";
    private static String NOMETABELA;
    private static final String TITULO = "titulo";
    private static final String ISBN = "ISBN";
    private static final String CODIGO = "codigo";
    private static final String EDITORA = "editora";
    private static final String NREDICAO = "nrEdicao";
    private static final String NRPAGINAS = "nrPaginas";
    private static final String AUTORES ="autores";
    private static final String PALAVRASCHAVES = "palavrasChave";


    public LivroDAL(Context pContext){

            this.context = pContext;
            NOMETABELA =  context.getString(R.string.NOMETABELALIVRO);
    }

    public static String createTableLivro(String pNomeTabela) {

        Log.i("CRIABANCO","CHAMOU O ONCREATE tabela "+pNomeTabela);

        String ddl = "CREATE TABLE " + pNomeTabela + " (" +
                " id INTEGER PRIMARY KEY autoincrement," +
                " "+TITULO+" TEXT," +
                " "+ISBN+" TEXT," +
                " "+CODIGO+" TEXT," +
                " "+EDITORA+" TEXT," +
                " "+NREDICAO+" INTEGER," +
                " "+NRPAGINAS+" INTEGER,"+
                " "+CODIGOCATEGORIA+" INTEGER," +
                " "+AUTORES+" TEXT," +
                " "+PALAVRASCHAVES+" TEXT" +
                ")";
        return  ddl;
    }

    public static  String dropTableLivro(String pNomeTabela){
        return "DROP TABLE IF EXISTS "+pNomeTabela;
    }

    public void incluirLivro(Livro livro) {

            ContentValues values = new ContentValues();

            values.put(TITULO, livro.getTítulo());
            values.put(ISBN, livro.getIssbn());
            values.put(CODIGO, livro.getCodigo());
            values.put(CODIGOCATEGORIA, livro.getCategoriaDeLivro().getCodigoCategoria());
            values.put(EDITORA, livro.getEditora());
            values.put(NREDICAO, livro.getNrEdicao());
            values.put(NRPAGINAS, livro.getNrPaginas());
            values.put(AUTORES, Arrays.toString(livro.getAutores()));
            values.put(PALAVRASCHAVES, Arrays.toString(livro.getPalavrasChave()));

        BiblioSYSDB biblioSYSDB = new BiblioSYSDB(context);

        SQLiteDatabase db  = biblioSYSDB.getWritableDatabase();

        long resultado =db.insert(NOMETABELA, null, values);

        db.close();
    }

    public ArrayList<Livro> listarLivros() {

        ArrayList<Livro> listaLivros = new ArrayList<>();

        String query = "SELECT * FROM " + NOMETABELA ;

        BiblioSYSDB biblioSYSDB = new BiblioSYSDB(context);

        SQLiteDatabase db  = biblioSYSDB.getWritableDatabase();

        Cursor cursor =db.rawQuery(query,null);

        while (cursor.moveToNext()){

            Livro livro = new Livro();

            livro.setId(cursor.getLong(cursor.getColumnIndex("id")));
            livro.setIssbn(cursor.getString(cursor.getColumnIndex(ISBN)));
            livro.setTítulo(cursor.getString(cursor.getColumnIndex(TITULO)));
            livro.setNrPaginas(cursor.getInt(cursor.getColumnIndex(NRPAGINAS)));
            livro.setCodigo(cursor.getString(cursor.getColumnIndex(CODIGO)));
//            livro.setCategoriaDeLivro(cursor.getString(cursor.getColumnIndex(CODIGOCATEGORIA)));
            livro.setNrEdicao(cursor.getInt(cursor.getColumnIndex(NREDICAO)));
            livro.setEditora(cursor.getString(cursor.getColumnIndex(EDITORA)));
            livro.setPalavrasChave(new String[]{cursor.getString(cursor.getColumnIndex(PALAVRASCHAVES))});
            livro.setAutores(new  String[]{cursor.getString(cursor.getColumnIndex(AUTORES))});

            listaLivros.add(livro);
        }

        cursor.close();

        return  listaLivros;
    }
}
