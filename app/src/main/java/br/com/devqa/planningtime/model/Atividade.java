package br.com.devqa.planningtime.model;

import java.util.Date;

/**
 * Created by Tatiane on 26/05/2017.
 */

public class Atividade {

    private int id;
    private String nome;
    private int duracao;
    private String prioridade;
    private Date data;

    public Atividade(int id, String nome, int duracao, String prioridade, Date data) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.prioridade = prioridade;
        this.data = data;
    }
    public Atividade(String nome, int duracao, String prioridade, Date data) {
        this.nome = nome;
        this.duracao = duracao;
        this.prioridade = prioridade;
        this.data = data;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
