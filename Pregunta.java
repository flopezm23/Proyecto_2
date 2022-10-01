package com.example.proyecto2_2022;

public class Pregunta {
    String pergunta;
    String respuesta1;

    String respuesta2;

    String respuesta3;

    String respuesta4;

    int punteo;
    int tempo;
    int identificator;

    int answer;

    public Pregunta(String pergunta, int punteo, int tempo, int identificator, String respuesta1,String respuesta2,String respuesta3,String respuesta4,int answer) {
        this.pergunta = pergunta;
        this.respuesta1 = respuesta1;
        this.punteo = punteo;
        this.tempo = tempo;
        this.identificator = identificator;
        this.respuesta2=respuesta2;
        this.respuesta3=respuesta3;
        this.respuesta4=respuesta4;
        this.answer=answer;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public int getPunteo() {
        return punteo;
    }

    public int getTempo() {
        return tempo;
    }

    public int getIdentificator() {
        return identificator;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public void setPunteo(int punteo) {
        this.punteo = punteo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setIdentificator(int identificator) {
        this.identificator = identificator;
    }

}
