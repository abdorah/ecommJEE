package com.ecomm.javaBeans;

public class Famille {

    private int numeroFam;
    private String nomFam;
    
    public Famille() {
    }

    public Famille(int numeroFam, String nomFam) {
        this.numeroFam = numeroFam;
        this.nomFam = nomFam;
    }

    public int getNumeroFam() {
        return numeroFam;
    }
    public void setNumeroFam(int numeroFam) {
        this.numeroFam = numeroFam;
    }
    public String getNomFam() {
        return nomFam;
    }
    public void setNomFam(String nomFam) {
        this.nomFam = nomFam;
    }

}
