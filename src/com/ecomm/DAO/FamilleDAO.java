package com.ecomm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecomm.javaBeans.Famille;

public class FamilleDAO implements FamilleService {

    private DbConfigDAO dbInstance;
	private Connection connection;

	public FamilleDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

    @Override
    public Famille getFamilleByNum(int num) throws SQLException {
        String query ="SELECT nomFam FROM ecomm.famille WHERE numFam = ?;";
        PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, num);
		ResultSet result = preStat.executeQuery();
		Famille famille = new Famille();
		if (result.next()) {
			String nom = result.getString("nomFam");
			famille = new Famille(num, nom);
		}
		return famille;
    }

    @Override
    public Famille getFamilleByNom(String nom) throws SQLException {
        String query ="SELECT numFam FROM ecomm.famille WHERE nomFam = ?;";
        PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setString(1, nom);
		ResultSet result = preStat.executeQuery();
		Famille famille = new Famille();
		if (result.next()) {
			int num = result.getInt("numFam");
			famille = new Famille(num, nom);
		}
		return famille;
    }

    @Override
    public List<Famille> getFamilles() throws SQLException {
        String query ="SELECT numFam, nomFam FROM ecomm.famille;";
        PreparedStatement preStat = connection.prepareStatement(query);
		ResultSet result = preStat.executeQuery();
		Famille famille = new Famille();
        List<Famille> familles = new ArrayList<Famille>();
		while (result.next()) {
			int num = result.getInt("numFam");
            String nom = result.getString("nomFam");
			famille = new Famille(num, nom);
            familles.add(famille);
		}
		return familles;
    }

	@Override
	public boolean addFamille(Famille famille) throws SQLException {
        String query = "INSERT INTO ecomm.famille(numFam, nomFam) VALUES(?, ?);";
        PreparedStatement preStat = connection.prepareStatement(queryCde);
        preStat.setInt(1, famille.getNumeroFam());
        preStat.setString(2, famille.getNomFam());
        boolean result = preStat.execute();
        return result;
	}

	@Override
	public boolean supprimerFamille(int numFam) throws SQLException {
		String query = "DELETE FROM ecomm.commande WHERE numCde=?;";
        PreparedStatement preStat;
        preStat = connection.prepareStatement(query);
        preStat.setInt(1, numCde);
        boolean resultFamPro = updateDeleteProFam( numFam);
		int result = preStat.executeUpdate();
        return result > 0 ? true : false & resultFamPro;
    }

    public boolean updateDeleteProFam(int numFam) throws SQLException {
        String queryProFam = "DELETE FROM ecomm.produit WHERE famPro=?";
        PreparedStatement preStat = connection.prepareStatement(queryProFam);
        preStat.setInt(1, numFam);
        boolean result = preStat.execute();
        return result;
    }
    
}
