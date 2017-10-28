package br.com.dinizdev.exemplorecycleview.Model;

/**
 * Created by eafdecision3 on 28/10/17.
 */

public class Pais {
    private String nome;
    private int bandeira;
    private int cartaoPostal;

    public Pais(String nome, int bandeira, int cartaoPostal) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.cartaoPostal = cartaoPostal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBandeira() {
        return bandeira;
    }

    public void setBandeira(int bandeira) {
        this.bandeira = bandeira;
    }

    public int getCartaoPostal() {
        return cartaoPostal;
    }

    public void setCartaoPostal(int cartaoPostal) {
        this.cartaoPostal = cartaoPostal;
    }
}
