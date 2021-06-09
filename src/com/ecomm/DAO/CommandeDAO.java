package com.ecomm.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecomm.javaBeans.Commande;
import com.ecomm.javaBeans.Produit;

public class CommandeDAO implements CommandeService {

    private DbConfigDAO dbInstance;
    private Connection connection;

    public CommandeDAO() {
        dbInstance = DbConfigDAO.getInstance();
        try {
            connection = dbInstance.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Commande getCommandeByNum(int num) throws SQLException {
        String query = "SELECT dateCde FROM ecomm.commande WHERE numCde = ?;";
        PreparedStatement preStat = connection.prepareStatement(query);
        preStat.setInt(1, num);
        ResultSet result = preStat.executeQuery();
        Commande commande = new Commande();
        if (result.next()) {
            Date date = result.getDate("dateCde");
            commande = new Commande(num, date);
        }
        return commande;
    }

    @Override
    public List<Commande> getCommandes(int num) throws SQLException {
        String query = "SELECT numCde, dateCde FROM ecomm.commande, ecomm.client WHERE numCli = ?;";
        PreparedStatement preStat = connection.prepareStatement(query);
        preStat.setInt(1, num);
        ResultSet result = preStat.executeQuery();
        Commande commande = new Commande();
        List<Commande> commandes = new ArrayList<Commande>();
        while (result.next()) {
            int numCde = result.getInt("numPro");
            Date date = result.getDate("puPro");
            commande = new Commande(numCde, date);
            commandes.add(commande);
        }
        return commandes;
    }

    @Override
    public boolean addCommande(Commande commande, Produit produit, int numUtil, int qte) throws SQLException {
        String queryCde = "INSERT INTO ecomm.commande(numCde, dateCde) VALUES(?, now());";
        PreparedStatement preStat = connection.prepareStatement(queryCde);
        preStat.setInt(1, commande.getNumCde());
        preStat.setDate(2, commande.getDateCde());
        boolean resultCde = preStat.execute();
        boolean resultCdPr = updateInsertCdPr(commande, produit, qte);
        boolean resultCdCl = updateInsertCdCl(commande, produit, numUtil, qte);
        boolean result = resultCdCl & resultCdPr & resultCde;
        return result;
    }

    @Override
    public boolean supprimerCommande(int numCde, int numPro, int numCli) throws SQLException {
        String query = "DELETE FROM ecomm.commande WHERE numCde=?;";
        PreparedStatement preStat;
        preStat = connection.prepareStatement(query);
        preStat.setInt(1, numCde);
        int result = preStat.executeUpdate();
        boolean resultCdPr = updateDeleteCdPr(numCde, numPro);
        boolean resultCdCl = updateDeleteCdCl(numCde, numCli);
        return result > 0 ? true : false & resultCdPr & resultCdCl;
    }

    public boolean updateInsertCdPr(Commande commande, Produit produit, int qte) throws SQLException {
        String queryCdPr = "INSERT INTO ecomm.procde (numpro, numcde, qte) VALUES(?, ?, ?);";
        PreparedStatement preStat = connection.prepareStatement(queryCdPr);
        preStat.setInt(1, produit.getNumPro());
        preStat.setInt(2, commande.getNumCde());
        preStat.setInt(3, qte);
        boolean result = preStat.execute();
        return result;
    }

    public boolean updateInsertCdCl(Commande commande, Produit produit, int numUtil, int qte) throws SQLException {
        String queryCdCl = "INSERT INTO ecomm.cdecli (numcde, numcli) VALUES(?, ?);";
        PreparedStatement preStat = connection.prepareStatement(queryCdCl);
        preStat.setInt(1, commande.getNumCde());
        preStat.setInt(2, numUtil);
        boolean result = preStat.execute();
        return result;
    }

    public boolean updateDeleteCdPr(int numCde, int numPro) throws SQLException {
        String queryCdPr = "DELETE FROM ecomm.cdecli WHERE numcde=? AND numcli=?;";
        PreparedStatement preStat = connection.prepareStatement(queryCdPr);
        preStat.setInt(1, numCde);
        preStat.setInt(2, numPro);
        boolean result = preStat.execute();
        return result;
    }

    public boolean updateDeleteCdCl(int numCde, int numCli) throws SQLException {
        String queryCdCl = "DELETE FROM ecomm.procde WHERE numpro=? AND numcde=?;";
        PreparedStatement preStat = connection.prepareStatement(queryCdCl);
        preStat.setInt(1, numCde);
        preStat.setInt(2, numCli);
        boolean result = preStat.execute();
        return result;
    }
}
