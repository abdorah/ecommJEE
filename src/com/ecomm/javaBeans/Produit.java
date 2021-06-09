package com.ecomm.javaBeans;

public class Produit {

    private int numPro;
    private int puPro;
    private String nomPro;
    private String famPro;

    public Produit() {
    }

    public Produit(int numPro, int puPro, String nomPro, String famPro) {
        this.numPro = numPro;
        this.puPro = puPro;
        this.nomPro = nomPro;
        this.famPro = famPro;
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

    public String getFamPro() {
        return famPro;
    }

    public void setFamPro(String famPro) {
        this.famPro = famPro;
    }

}
