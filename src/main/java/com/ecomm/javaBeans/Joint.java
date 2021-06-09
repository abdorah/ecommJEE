package com.ecomm.javaBeans;

public class Joint {

    private int numPro;
    private int numCde;
    private int numClient;
    private int qte;

    public Joint() {
    }

    public Joint(int numPro, int numCde, int numClient, int qte) {
        this.numPro = numPro;
        this.numCde = numCde;
        this.numClient = numClient;
        this.qte = qte;
    }

    public int getNumPro() {
        return numPro;
    }

    public void setNumPro(int numPro) {
        this.numPro = numPro;
    }

    public int getNumCde() {
        return numCde;
    }

    public void setNumCde(int numCde) {
        this.numCde = numCde;
    }

    public int getNumClient() {
        return numClient;
    }

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
