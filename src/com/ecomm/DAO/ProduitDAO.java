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
        String query = "SELECT puPro, nomPro, famPro, stock FROM ecomm.produit WHERE numPro = ?;";
        PreparedStatement preStat = connection.prepareStatement(query);
        preStat.setInt(1, num);
        ResultSet result = preStat.executeQuery();
        Produit produit = new Produit();
        if (result.next()) {
            int pu = result.getInt("puPro");
            String nomPro = result.getString("nomPro");
            int stock = result.getInt("stock");
            int nomFam = result.getInt("famPro");
            produit = new Produit(num, pu, nomPro, nomFam, stock);
        }
        return produit;
    }

    @Override
    public Produit getProduitByNom(String nom) throws SQLException {
        String query = "SELECT numPro, puPro, famPro, stock FROM ecomm.produit WHERE nomPro = ?;";
        PreparedStatement preStat = connection.prepareStatement(query);
        preStat.setString(1, nom);
        ResultSet result = preStat.executeQuery();
        Produit produit = new Produit();
        if (result.next()) {
            int num = result.getInt("numPro");
            int pu = result.getInt("puPro");
            int nomFam = result.getInt("famPro");
            int stock = result.getInt("stock");
            produit = new Produit(num, pu, nom, nomFam, stock);
        }
        return produit;
    }

    @Override
    public List<Produit> getPoduitsByFamilleNom(String nom) throws SQLException {
        String query = "SELECT numPro, puPro, nomPro, famPro, stock FROM ecomm.produit,ecomm.famille WHERE numFam=famPro AND nomFam = ?;";
        PreparedStatement preStat = connection.prepareStatement(query);
        preStat.setString(1, nom);
        ResultSet result = preStat.executeQuery();
        Produit produit = new Produit();
        List<Produit> produits = new ArrayList<Produit>();
        while (result.next()) {
            int num = result.getInt("numPro");
            int pu = result.getInt("puPro");
            String nomPro = result.getString("nomPro");
            int famPro = result.getInt("famPro");
            int stock = result.getInt("stock");
            produit = new Produit(num, pu, nomPro, famPro, stock);
            produits.add(produit);
        }
        return produits;
    }

    @Override
    public boolean addProduit(Produit produit) throws SQLException {
        String query = "INSERT INTO ecomm.produit(numPro, puPro, nomPro, famPro, stock) VALUES(?, ?, ?, ?, ?);";
        PreparedStatement preStat = connection.prepareStatement(query);
        preStat.setInt(1, produit.getNumPro());
        preStat.setInt(2, produit.getPuPro());
        preStat.setString(3, produit.getNomPro());
        preStat.setInt(4, produit.getFamPro());
        preStat.setInt(5, produit.getStock());
        boolean result = preStat.execute();
        return result;
    }

    @Override
    public boolean supprimerProduit(int numPro) throws SQLException {
        String queryPro = "DELETE FROM ecomm.produit WHERE numPro=?";
        PreparedStatement preStat = connection.prepareStatement(queryPro);
        preStat.setInt(1, numPro);
        boolean result = preStat.execute();
        return result;
    }

    @Override
    public boolean modifierProduit(int numPro, int qte) throws SQLException {
        String queryPro = "UPDATE ecomm.produit SET stock=? WHERE numPro=?;";
        PreparedStatement preStat = connection.prepareStatement(queryPro);
        preStat.setInt(1, numPro);
        preStat.setInt(2, qte);
        boolean result = preStat.execute();
        return result;
    }

}