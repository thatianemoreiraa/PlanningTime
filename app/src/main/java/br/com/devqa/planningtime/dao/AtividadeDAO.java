package br.com.devqa.planningtime.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.devqa.planningtime.model.Atividade;

/**
 * Created by Tatiane on 27/05/2017.
 */

public class AtividadeDAO implements IAtividadeDAO {

    private BdOpenHelper openHelper;
    private SQLiteDatabase banco;

    public AtividadeDAO (Context context) {
        openHelper = new BdOpenHelper(context);
    }

    @Override
    public void inserirAtividade(Atividade atividade) {
        banco = openHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nome", atividade.getNome());
        valores.put("duracao", atividade.getDuracao());
        valores.put("prioridade", atividade.getPrioridade());
        valores.put("data", atividade.getData().getTime());
        banco.insert("atividade", null, valores);
        banco.close();
    }

    @Override
    public List<Atividade> listar() {
        SQLiteDatabase banco = openHelper.getReadableDatabase();
        Cursor cursor = banco.query("atividade", new String[]{"id","nome","data","duracao","prioridade"}, null,null,null,null,"id");
        List<Atividade> atividades = new ArrayList<Atividade>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            int duracao = cursor.getInt(cursor.getColumnIndex("duracao"));
            String prioridade = cursor.getString(cursor.getColumnIndex("prioridade"));
            Date data = new Date(cursor.getLong(cursor.getColumnIndex("data")));
            atividades.add(new Atividade(id, nome, duracao, prioridade, data));
        }
        return atividades;
    }

    @Override
    public List<Atividade> listarPeloPeriodo(String dtInicio, String dtFim) {
        SQLiteDatabase banco = openHelper.getReadableDatabase();
        Cursor cursor = banco.query("atividade", new String[]{"id","nome","duracao","prioridade", "data"}, "data >= ? or data <= ?", new String[] {dtInicio, dtFim},null,null,"id");
        List<Atividade> atividades = new ArrayList<Atividade>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            int duracao = cursor.getInt(cursor.getColumnIndex("duracao"));
            String prioridade = cursor.getString(cursor.getColumnIndex("prioridade"));
            Date data = new Date(cursor.getLong(cursor.getColumnIndex("data")));
            atividades.add(new Atividade(id, nome, duracao, prioridade, data));
        }
        return atividades;
    }

    @Override
    public void atualizar(Atividade atividade) {
        banco = openHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nome", atividade.getNome());
        valores.put("duracao", atividade.getDuracao());
        valores.put("prioridade", atividade.getPrioridade());
        valores.put("data", atividade.getData().getTime());
        banco.update("atividade",valores,"id=?", new String[]{String.valueOf(atividade.getId())});
        banco.close();
    }

    @Override
    public void excluir(Atividade atividade) {
        SQLiteDatabase banco = openHelper.getWritableDatabase();
        banco.delete("atividade","id=?", new String[]{String.valueOf(atividade.getId())});
        banco.close();
    }
}
