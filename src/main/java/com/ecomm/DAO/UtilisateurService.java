package com.ecomm.DAO;

import java.sql.SQLException;

import com.ecomm.javaBeans.Administrateur;
import com.ecomm.javaBeans.Client;
import com.ecomm.javaBeans.Utilisateur;

public interface UtilisateurService {
	public Utilisateur checkLogin(String email, String password) throws SQLException;
	public boolean isExist(String email) throws SQLException;
	public int register(Client client) throws SQLException;
	public int addAdmin(Administrateur administrateur) throws SQLException;
}
