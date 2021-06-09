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
		preStat.close();
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
		preStat.close();
		return famille;
    }

    @Override
    public List<Famille> getFamilles() throws SQLException {
        String query ="SELECT numFam, nomFam FROM ecomm.famille;";
        PreparedStatement preStat = connection.prepareStatement(query);
		ResultSet result = preStat.executeQuery();
		Famille famille = new Famille();
        List<Famille> familles = new ArrayList<Famille>();
		if (result.next()) {
			int num = result.getInt("numFam");
            String nom = result.getString("nomFam");
			famille = new Famille(num, nom);
            familles.add(famille);
		}
		preStat.close();
		return familles;
    }
    
}
