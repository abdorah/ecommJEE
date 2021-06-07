package com.ecomm.DAO;

import java.util.List;

import com.ecomm.javaBeans.Commande;

public interface CommandeService {
    public Commande getCommandeByNum(int num);
    public List<Commande> getCommandes();
}
