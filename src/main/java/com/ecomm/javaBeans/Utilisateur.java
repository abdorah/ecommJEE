package com.ecomm.javaBeans;

public class Utilisateur {
	
	private int numUtil;
	private String nomUtil;
	private String prenomUtil;
	private String adrUtil;
	private String pass;
	private String accountType;
	
	public Utilisateur() {
	}

	public Utilisateur(int numUtil, String nomUtil, String prenomUtil, String adrUtil, String pass) {
		this.numUtil = numUtil;
		this.nomUtil = nomUtil;
		this.prenomUtil = prenomUtil;
		this.adrUtil = adrUtil;
		this.pass = pass;
	}



	public int getNumUtil() {
		return numUtil;
	}

	public void setNumUtil(int numUtil) {
		this.numUtil = numUtil;
	}

	public String getNomUtil() {
		return nomUtil;
	}

	public void setNomUtil(String nomUtil) {
		this.nomUtil = nomUtil;
	}

	public String getPrenomUtil() {
		return prenomUtil;
	}

	public void setPrenomUtil(String prenomUtil) {
		this.prenomUtil = prenomUtil;
	}

	public String getAdrUtil() {
		return adrUtil;
	}

	public void setAdrUtil(String adrUtil) {
		this.adrUtil = adrUtil;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}