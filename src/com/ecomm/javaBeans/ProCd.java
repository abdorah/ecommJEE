package com.ecomm.javaBeans;

public class ProCd {
    
    private int numPro;
    private int numCde;
    private int qte;

    public ProCd(){
    }
    
    public ProCd(int numPro, int numCde, int qte) {
        this.numPro = numPro;
        this.numCde = numCde;
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
    public int getQte() {
        return qte;
    }
    public void setQte(int qte) {
        this.qte = qte;
    }
    
}
