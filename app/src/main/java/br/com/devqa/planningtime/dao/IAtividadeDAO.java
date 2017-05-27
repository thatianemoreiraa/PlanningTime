package br.com.devqa.planningtime.dao;

import java.util.List;

import br.com.devqa.planningtime.model.Atividade;

/**
 * Created by Tatiane on 26/05/2017.
 */

public interface IAtividadeDAO {

    void inserirAtividade(Atividade atividade);
    List<Atividade> listar();
    List<Atividade> listarPeloPeriodo(String dtInicio, String dtFim);
    void atualizar(Atividade atividade);
    void excluir (Atividade atividade);
}
