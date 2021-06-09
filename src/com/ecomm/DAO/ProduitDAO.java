package com.ecomm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecomm.javaBeans.Produit;

public class ProduitDAO implements ProduitService {

    private DbConfigDAO dbInstance;
    private Connection connection;

    public ProduitDAO() {
        dbInstance = DbConfigDAO.getInstance();
        try {
            connection = dbInstance.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Produit getProduitByNum(int num) throws SQLException {
        String query = "SELECT puPro, nomPro, nomFam FROM ecomm.produit WHERE numPro = ?;";
        PreparedStatement preStat = connection.prepareStatement(query);
        preStat.setInt(1, num);
        ResultSet result = preStat.executeQuery();
        Produit produit = new Produit();
        if (result.next()) {
            int pu = result.getInt("puPro");
            String nomPro = result.getString("nomPro");
            String nomFam = result.getString("nomFam");
            produit = new Produit(num, pu, nomPro, nomFam);
        }
        return produit;
    }

    @Override
    public Produit getProduitByNom(String nom) throws SQLException {
        String query = "SELECT numPro, puPro, nomFam FROM ecomm.produit WHERE nomPro = ?;";
        PreparedStatement preStat = connection.prepareStatement(query);
        preStat.setString(1, nom);
        ResultSet result = preStat.executeQuery();
        Produit produit = new Produit();
        if (result.next()) {
            int num = result.getInt("numPro");
            int pu = result.getInt("puPro");
            String nomFam = result.getString("nomFam");
            produit = new Produit(num, pu, nom, nomFam);
        }
        return produit;
    }

    @Override
    public List<Produit> getPoduitsByFamilleNom(String nom) throws SQLException {
        String query = "SELECT numPro, puPro, nomPro FROM ecomm.produit WHERE famPro = ?;";
        PreparedStatement preStat = connection.prepareStatement(query);
        preStat.setString(1, nom);
        ResultSet result = preStat.executeQuery();
        Produit produit = new Produit();
        List<Produit> produits = new ArrayList<Produit>();
        while (result.next()) {
            int num = result.getInt("numPro");
            int pu = result.getInt("puPro");
            String nomPro = result.getString("nomPro");
            produit = new Produit(num, pu, nomPro, nom);
            produits.add(produit);
        }
        return produits;
    }

    @Override
    public boolean addProduit(Produit produit) throws SQLException {
        String query = "INSERT INTO ecomm.produit(numPro, puPro, nomPro, famPro) VALUES(0, 0, '', 0);";
        PreparedStatement preStat = connection.prepareStatement(queryCde);
        preStat.setInt(1, produit.getNumPro());
        preStat.setInt(2, produit.getPuPro());
        preStat.setString(3, produit.getNomPro());
        preStat.setInt(4, produit.getFamPro());
        boolean result = preStat.execute();
        return result;
    }

    @Override
    public boolean supprimerProduit(int numPro) throws SQLException {
        String queryPro = "DELETE FROM ecomm.produit WHERE numPro=?";
        PreparedStatement preStat = connection.prepareStatement(queryPro);
        preStat.setInt(1, num);
        boolean result = preStat.execute();
        return result;
    }

}
