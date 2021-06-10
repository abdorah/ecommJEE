package com.ecomm.servelt;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecomm.DAO.CommandeDAO;
import com.ecomm.DAO.ProduitDAO;
import com.ecomm.javaBeans.Commande;
import com.ecomm.javaBeans.Produit;

@WebServlet("/Commandes")
public class Commandes extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Commande> commandes = new ArrayList<Commande>();
        CommandeDAO CommandesDao = new CommandeDAO();
        Commande commande = new Commande(Integer.parseInt(request.getParameter("numCommande")),
                Date.valueOf(LocalDate.now()));
        commandes.add(commande);
        boolean confirme = Boolean.parseBoolean(request.getParameter("confirme"));
        if (confirme) {
            ProduitDAO produitDAO = new ProduitDAO();
            Produit produit;
            try {
                produit = produitDAO.getProduitByNom(request.getParameter("nomPro"));
                int numUtil = Integer.parseInt(request.getParameter("numUtil"));
                int qte = Integer.parseInt(request.getParameter("qte"));
                CommandesDao.addCommande(commande, produit, numUtil, qte);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/Commandes.jsp").forward(request, response);

    }
}