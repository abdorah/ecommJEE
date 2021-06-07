package com.ecomm.javaBeans;

import java.util.Date;

public class Commande {
    
    private int numCde;
    private Date dateCde;

    public Commande() {
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
