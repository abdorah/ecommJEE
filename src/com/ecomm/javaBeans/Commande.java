package com.ecomm.javaBeans;

import java.sql.Date;

public class Commande {
    
    private int numCde;
    private Date dateCde;

    public Commande() {
    }

    public Commande(int num, Date date) {
    }

    public int getNumCde() {
        return numCde;
    }

    public void setNumCde(int numCde) {
        this.numCde = numCde;
    }

    public Date getDateCde() {
        return dateCde;
    }

    public void setDateCde(Date dateCde) {
        this.dateCde = dateCde;
    }
}
