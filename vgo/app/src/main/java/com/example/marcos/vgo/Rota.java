package com.example.marcos.vgo;

/**
 * Created by marcos on 01/06/17.
 */

public class Rota {
    private String nome;
    private String descricao;

    public Rota(String nome, String descricao){
        this.setNome(nome);
        this.setDescricao(descricao);
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
}