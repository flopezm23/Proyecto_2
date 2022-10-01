package com.example.proyecto2_2022;

public class Cuestionario {
    int pin;
    int identificador;
    String nome;
    String status;
    String descripcion;


    public Cuestionario(int pin, int identificador, String nome,String descripcion, String status) {
        this.pin = pin;
        this.identificador = identificador;
        this.descripcion=descripcion;
        this.nome = nome;
        this.status = status;
    }

    public int getPin() {
        return pin;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNome() {
        return nome;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStatus() {
        return status;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
