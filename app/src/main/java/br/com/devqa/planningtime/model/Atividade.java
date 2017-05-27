package br.com.devqa.planningtime.model;

import java.util.Date;

/**
 * Created by Tatiane on 26/05/2017.
 */

public class Atividade {

    private int id;
    private int usuarioId;
    private String nome;
    private int duracao;
    private String prioridade;
    private Date data;

    public Atividade(int id, int idUsuario, String nome, int duracao, String prioridade, Date data) {
        this.id = id;
        this.usuarioId = idUsuario;
        this.nome = nome;
        this.duracao = duracao;
        this.prioridade = prioridade;
        this.data = data;
    }
    public Atividade(int idUsuario, String nome, int duracao, String prioridade, Date data) {
        this.usuarioId = idUsuario;
        this.nome = nome;
        this.duracao = duracao;
        this.prioridade = prioridade;
        this.data = data;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
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
