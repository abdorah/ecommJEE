package com.ecomm.DAO;

import java.sql.SQLException;
import java.util.List;

import com.ecomm.javaBeans.Commande;
import com.ecomm.javaBeans.Produit;

public class CommandeDAO implements CommandeService{

    @Override
    public Commande getCommandeByNum(int num) throws SQLException {
        return null;
    }

    @Override
    public List<Commande> getCommandes() throws SQLException {
        return null;
    }

    @Override
    public boolean addCommande(Commande commande, Produit produit, int qte) throws SQLException {
        return false;
    }

    @Override
    public boolean supprimerCommande(int numCde, int numPro) throws SQLException {
        return false;
    }
    
}
