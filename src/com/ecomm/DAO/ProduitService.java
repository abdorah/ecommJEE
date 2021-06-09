package com.ecomm.DAO;

import java.sql.SQLException;
import java.util.List;

import com.ecomm.javaBeans.Produit;

public interface ProduitService {
    public Produit getProduitByNum(int num) throws SQLException;
    public Produit getProduitByNom(String nom) throws SQLException;
    public List<Produit> getPoduitsByFamilleNom(String nom) throws SQLException;
    public boolean addProduit(Produit produit) throws SQLException;
    public boolean supprimerProduit(int numPro) throws SQLException;
    public boolean modifierProduit(int numPro, int qte) throws SQLException;
}