package com.example.marcos.vgo;
/**
 * Created by marcos on 31/05/17.
 */

public class Usuario {
    private String nome;
    private String cpf;

    public Usuario(String nome, String cpf) {
        this.setNome(nome);
        this.setCpf(cpf);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
