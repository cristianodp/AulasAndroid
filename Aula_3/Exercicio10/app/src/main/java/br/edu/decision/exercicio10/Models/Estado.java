package br.edu.decision.exercicio10.Models;

/**
 * Created by crist on 30/09/2017.
 */

public class Estado {
    String nome;
    String uf;
    String capital;
    int bandeira;
    double area;

    public Estado(String nome, String uf, String capital, int bandeira, double area) {
        this.nome = nome;
        this.uf = uf;
        this.capital = capital;
        this.bandeira = bandeira;
        this.area = area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getBandeira() {
        return bandeira;
    }

    public void setBandeira(int bandeira) {
        this.bandeira = bandeira;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
