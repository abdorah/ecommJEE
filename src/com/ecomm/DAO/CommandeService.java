package com.ecomm.DAO;

import java.sql.SQLException;
import java.util.List;

import com.ecomm.javaBeans.Commande;
import com.ecomm.javaBeans.Produit;

public interface CommandeService {
    public Commande getCommandeByNum(int num) throws SQLException;
    public List<Commande> getCommandes() throws SQLException;
    public boolean addCommande(Commande commande, Produit produit, int qte) throws SQLException;
    public boolean supprimerCommande(int numCde, int numPro) throws SQLException;
}
