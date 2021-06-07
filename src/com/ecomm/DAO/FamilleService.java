package com.ecomm.DAO;

import java.util.List;

import com.ecomm.javaBeans.Famille;

public interface FamilleService {
    public Famille getFamilleByNum(int num);
    public Famille getFamilleByNom(String nom);
    public List<Famille> getFamilles();
}
