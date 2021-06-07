package com.ecomm.DAO;

import java.util.List;

import com.ecomm.javaBeans.Produit;

public interface ProduitService {
    public Produit getProduitByNum(int num);
    public List<Produit> getPoduits(); 
    public Produit getProduitByNom(String nom);
}
