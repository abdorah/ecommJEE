package com.ecomm.DAO;

import java.sql.SQLException;
import java.util.List;

import com.ecomm.javaBeans.Commande;
import com.ecomm.javaBeans.Produit;

public interface CommandeService {
    List<Commande> getAllCommandes() throws SQLException;
    public Commande getCommandeByNum(int num) throws SQLException;
    public List<Commande> getCommandes(int num) throws SQLException;
    public int addCommande(Produit produit, int numUtil, int qte) throws SQLException;
    public boolean supprimerCommande(int numCde, int numPro, int numCli) throws SQLException;
}
