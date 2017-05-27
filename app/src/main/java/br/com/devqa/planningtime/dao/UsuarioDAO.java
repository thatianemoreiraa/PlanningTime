package br.com.devqa.planningtime.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.devqa.planningtime.model.Usuario;

/**
 * Created by Tatiane on 27/05/2017.
 */

public class UsuarioDAO implements IUsuarioDAO {

    private BdOpenHelper openHelper;
    private SQLiteDatabase banco;

    public UsuarioDAO (Context context) {
        openHelper = new BdOpenHelper(context);
    }

    @Override
    public void atualizar(Usuario usuario) {
        banco = openHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        valores.put("senha", usuario.getSenha());
        banco.update("usuario",valores,"id=?",new String[]{String.valueOf(usuario.getId())});
        banco.close();
    }

    @Override
    public void inserirUsuario(Usuario usuario) {
        banco = openHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        valores.put("senha", usuario.getSenha());
        banco.insert("usuario", null, valores);
        banco.close();
    }

    @Override
    public Usuario pesquisarPeloNomeSenha(String nome, String senha) {
        banco = openHelper.getReadableDatabase();
        Cursor cursor = banco.query("usuario", new String[]{"id"}, "nome = ? and senha = ?", new String[] {nome, senha}, null, null, null);
        if (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            banco.close();
            return new Usuario(id, nome, senha);
        }
        banco.close();
        return null;
    }
}
