package com.ecomm.javaBeans;

public class Client extends Utilisateur {

    public Client() {
        super();
    }

    @Override
    public String getAccountType() {
        return super.getAccountType();
    }

    @Override
    public String getAdrUtil() {
        return super.getAdrUtil();
    }

    @Override
    public String getNomUtil() {
        return super.getNomUtil();
    }

    @Override
    public int getNumUtil() {
        return super.getNumUtil();
    }

    @Override
    public String getPass() {
        return super.getPass();
    }

    @Override
    public String getPrenomUtil() {
        return super.getPrenomUtil();
    }

    @Override
    public void setAccountType(String accountType) {
        super.setAccountType(accountType);
    }

    @Override
    public void setAdrUtil(String adrUtil) {
        super.setAdrUtil(adrUtil);
    }

    @Override
    public void setNomUtil(String nomUtil) {
        super.setNomUtil(nomUtil);
    }

    @Override
    public void setNumUtil(int numUtil) {
        super.setNumUtil(numUtil);
    }

    @Override
    public void setPass(String pass) {
        super.setPass(pass);
    }

    @Override
    public void setPrenomUtil(String prenomUtil) {
        super.setPrenomUtil(prenomUtil);
    }
}
