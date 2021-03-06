package com.ecomm.javaBeans;

public class Produit {

    private int numPro;
    private int puPro;
    private String nomPro;
    private int famPro;
    private int stock;

    public Produit() {
    }

    public Produit(int numPro, int puPro, String nomPro, int famPro, int stock) {
        this.numPro = numPro;
        this.puPro = puPro;
        this.nomPro = nomPro;
        this.famPro = famPro;
        this.stock = stock;
    }

    public int getNumPro() {
        return numPro;
    }

    public void setNumPro(int numPro) {
        this.numPro = numPro;
    }

    public int getPuPro() {
        return puPro;
    }

    public void setPuPro(int puPro) {
        this.puPro = puPro;
    }

    public String getNomPro() {
        return nomPro;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public int getFamPro() {
        return famPro;
    }

    public void setFamPro(int famPro) {
        this.famPro = famPro;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
