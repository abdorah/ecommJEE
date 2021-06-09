package com.ecomm.DAO;

import java.util.List;

import com.ecomm.javaBeans.Administrateur;

public interface AdministrateurService {
    public Administrateur getAdminstrateurByNum();
    public List<Administrateur> getAdminstrateurs();
}