package com.example.ftec.ajudadigital.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ftec.ajudadigital.modelo.Doacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiago on 06/11/17.
 */

public class DoacaoDao extends SQLiteOpenHelper {

    public DoacaoDao(Context context) {
        super(context, "AjudaDigital", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "CREATE TABLE Doacao (id INTEGER PRIMARY KEY, nome_item TEXT NOT NULL, data TEXT, quantidade INTEGER);";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS Doacao";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public void insert(Doacao doacao) {

        //Pedindo o Banco de Dados pois nele tem uma funcao de insert
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        //Abrindo o mapeamento dos dados para o insert
        ContentValues dados = new ContentValues();

        dados.put("nome_item",doacao.getNome_item());
        dados.put("data",doacao.getData());
        dados.put("quantidade",doacao.getQuantidade());


        sqLiteDatabase.insert("Doacao",null, dados);

    }

    public List<Doacao> buscaDoacao() {

        String sql = "SELECT * FROM Doacao";
        //Pedindo o Banco de dados para leitura somente
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        //Metodo rawQuery retorna um Cursor
        Cursor c = sqLiteDatabase.rawQuery(sql,null);

        List<Doacao> doacoes = new ArrayList<Doacao>();


        while(c.moveToNext()){
            Doacao doacao = new Doacao();
            doacao.setId(c.getLong(c.getColumnIndex("id")));
            doacao.setNome_item(c.getString(c.getColumnIndex("nome_item")));
            doacao.setData(c.getString(c.getColumnIndex("data")));
            doacao.setQuantidade(c.getInt(c.getColumnIndex("quantidade")));

            doacoes.add(doacao);
        }
        //Fechar o Cursos para liberar a memória
        c.close();


        return doacoes;
    }

    public void delete(Doacao doacao) {

        //Pedindo o Banco de Dados pois nele tem uma funcao de insert
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        String[] params = {doacao.getId().toString()};
        sqLiteDatabase.delete("Doacao","id = ?",params);

    }

    public void update(Doacao doacao) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        //Abrindo o mapeamento dos dados para o update
        ContentValues dados = new ContentValues();

        dados.put("nome_item",doacao.getNome_item());
        dados.put("data",doacao.getData());
        dados.put("quantidade",doacao.getQuantidade());


        String[] params = {doacao.getId().toString()};

        sqLiteDatabase.update("Doacao",dados,"id = ?",params);
    }

}
