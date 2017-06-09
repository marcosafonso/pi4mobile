package com.example.marcos.vgo;
/**
 * Created by marcos on 31/05/17.
 */

public class Usuario {
    private String usuario;
    private String senha;

    public Usuario(String usuario, String cpf) {
        this.setUsuario(usuario);
        this.setSenha(senha);
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return usuario;
    }

    public void setSenha(String usuario) {
        this.usuario = usuario;
    }
}
