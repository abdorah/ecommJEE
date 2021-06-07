
package com.ecomm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecomm.javaBeans.Client;
import com.ecomm.javaBeans.Utilisateur;

public class UtilisateurDAO implements UtilisateurService {

	private DbConfigDAO dbInstance;
	private Connection connection;

	public UtilisateurDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// for login:
	@Override
	public Utilisateur checkLogin(String email, String password) throws SQLException {

		String query = "SELECT * FROM utilisateur WHERE addrUtil = ? and passUtil = ?";
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setString(1, email);
		preStat.setString(2, password);
		ResultSet result = preStat.executeQuery();

		Utilisateur user = null;

		if (result.next()) {
			int id = result.getInt("numUtil");
			String firstName = result.getString("nomUtil");
			String lastName = result.getString("prenomUtil");
			String accountType = result.getString("typeCompte");

			user = new Utilisateur(id, firstName, lastName, email, password);
			user.setAccountType(accountType);
		}

		preStat.close();

		return user;
	}

	// for register:
	@Override
	public boolean isExist(String email, String cin) throws SQLException {
		boolean exist = true;
		String query = "SELECT numUtil FROM utilisateur WHERE addrUtil = ?";
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setString(1, email);
		ResultSet resultSet = preStat.executeQuery();

		exist = resultSet.next() ? true : false;
		preStat.close();

		return exist;
	}

	@Override
	public int register(Client client) throws SQLException {

		/*
		 * / insert the client in the table user:
		 */

		String userQuery = "INSERT INTO utilisateur (nomUtil, prenomUtil, addrUtil, passUtil) VALUES(?,?,?,?)";

		PreparedStatement preStatOfUtilisateur = connection.prepareStatement(userQuery);

		// set attributes
		preStatOfUtilisateur.setString(1, client.getNomUtil());
		preStatOfUtilisateur.setString(2, client.getPrenomUtil());
		preStatOfUtilisateur.setString(3, client.getAdrUtil());
		preStatOfUtilisateur.setString(4, client.getPass());

		preStatOfUtilisateur.executeUpdate();

		String maxQuery = "SELECT MAX(numUtil) AS MID FROM utilisateur";
		PreparedStatement ms = connection.prepareStatement(maxQuery);
		ResultSet resultSet = ms.executeQuery();
		if (resultSet.next()) {
			client.setNumUtil(resultSet.getInt("MID"));
		}

		/*
		 * / insert the client in the table client:
		 */
		String clientQuery = "INSERT INTO ecomm.client (numCli) VALUES (?)";

		PreparedStatement preStatOfclient = connection.prepareStatement(clientQuery);

		preStatOfclient.setInt(1, client.getNumUtil());

		// Execute statements
		preStatOfclient.executeUpdate();

		// close statement
		preStatOfclient.close();
		preStatOfUtilisateur.close();
		return 0;
	}

}
