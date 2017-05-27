package br.com.devqa.planningtime.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tatiane on 26/05/2017.
 */

public class BdOpenHelper extends SQLiteOpenHelper {

    private static String NOME_BD = "planyourtime.bd";

    private static String TB_USUARIO = "CREATE TABLE usuario" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome VARCHAR(30)," +
            "telefone VARCHAR(10));";

    private static String TB_ATIVIDADE = "CREATE TABLE atividade" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome VARCHAR(30)," +
            "descricao VARCHAR(100)," +
            "duracao INTEGER," +
            "prioridade VARCHAR(5)," +
            "data DATE);";

    public BdOpenHelper (Context context) {
        super(context, NOME_BD, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TB_USUARIO);
        db.execSQL(TB_ATIVIDADE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //// TODO: 25/05/2017
    }
}
