package br.com.dinizdev.exemploretrofit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by eafdecision3 on 21/10/17.
 */

public class Pacote {


    @SerializedName("titulo_oferta")
    @Expose
    private String titulo;
    @SerializedName("texto_parcelamento")
    @Expose
    private String nome;
    @SerializedName("valor_original")
    @Expose
    private double preco;
    @SerializedName("id_oferta_tipo")
    @Expose
    private int numDiarias;
    @SerializedName("url_imagem")
    @Expose
    private String[] imagem;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getNumDiarias() {
        return numDiarias;
    }

    public void setNumDiarias(int numDiarias) {
        this.numDiarias = numDiarias;
    }

    public String getImagem() {
        return imagem[0];
    }

    public void setImagem(String imagem) {
        this.imagem[0] = imagem;
    }
}
