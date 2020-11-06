package com.pauloandre.n2_http;

import android.graphics.Bitmap;

public class User {
    private String idUsuario;
    private String nome;
    private Bitmap avatar;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public User() {
        super();
    }

    public Bitmap getAvatar() { return avatar; }

    public void setAvatar(Bitmap avatar) { this.avatar = avatar; }
}
