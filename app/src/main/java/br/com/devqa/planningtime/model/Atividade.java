package br.com.devqa.planningtime.model;

import java.util.Date;

/**
 * Created by Tatiane on 26/05/2017.
 */

public class Atividade {

    private int id;
    private String nome;
    private String descricao;
    private int duracao;
    private String prioridade;
    private Date dataInicio;
    private Date dataFim;

    public Atividade(int id, String nome, String descricao, int duracao, String prioridade, Date dataInicio, Date dataFim) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.prioridade = prioridade;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
    public Atividade(String nome, String descricao, int duracao, String prioridade, Date dataInicio, Date dataFim) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.prioridade = prioridade;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
