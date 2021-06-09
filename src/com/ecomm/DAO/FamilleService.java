package com.ecomm.DAO;

import java.sql.SQLException;
import java.util.List;

import com.ecomm.javaBeans.Famille;

public interface FamilleService {
    public Famille getFamilleByNum(int num) throws SQLException;
    public Famille getFamilleByNom(String nom) throws SQLException;
    public List<Famille> getFamilles() throws SQLException;
}
