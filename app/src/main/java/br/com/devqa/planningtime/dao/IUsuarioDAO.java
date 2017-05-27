package br.com.devqa.planningtime.dao;

import br.com.devqa.planningtime.model.Usuario;

/**
 * Created by Tatiane on 26/05/2017.
 */

public interface IUsuarioDAO {

    void atualizar(Usuario usuario);
    void inserirUsuario(Usuario usuario);
    Usuario pesquisarPeloNomeSenha(String nome, String senha);
}
