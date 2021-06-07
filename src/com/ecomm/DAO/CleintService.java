package com.ecomm.DAO;

import java.util.List;

import com.ecomm.javaBeans.Client;

public interface CleintService {
    public Client getClientByNum(int num);
    public List<Client> getClients(); 
}
