package com.example.proyecto2_2022;

public class Evaluaciones {
    double punteo;
    String cuestionario;
    String nickname;

    public Evaluaciones(double punteo, String cuestionario, String nickname) {
        this.punteo = punteo;
        this.cuestionario = cuestionario;
        this.nickname = nickname;
    }

    public double getPunteo() {
        return punteo;
    }

    public void setPunteo(double punteo) {
        this.punteo = punteo;
    }

    public String getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(String cuestionario) {
        this.cuestionario = cuestionario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
