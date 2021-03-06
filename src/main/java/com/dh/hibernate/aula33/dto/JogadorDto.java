package com.dh.hibernate.aula33.dto;

import com.dh.hibernate.aula33.model.Time;

public class JogadorDto {

    private String nome;
    private String posicao;
    private Double peso;
    private Double altura;
    private Time time;

    public JogadorDto() {
    }

    public JogadorDto(String nome, String posicao, Double peso, Double altura, Time time) {
        this.nome = nome;
        this.posicao = posicao;
        this.peso = peso;
        this.altura = altura;
        this.time = time;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
