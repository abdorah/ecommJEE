package com.ecomm.servelt;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecomm.DAO.CommandeDAO;
import com.ecomm.DAO.ProduitDAO;
import com.ecomm.javaBeans.Commande;
import com.ecomm.javaBeans.Produit;
import com.ecomm.javaBeans.Utilisateur;

@WebServlet("/Commandes")
public class Commandes extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext servletcontext = getServletContext();
        int numPro = (int)servletcontext.getAttribute("numpro");
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmaaaaaa"+numPro);
        ProduitDAO produitDAO = new ProduitDAO();
        CommandeDAO commandesDao = new CommandeDAO();
        try {
            Produit produit = produitDAO.getProduitByNum(numPro);
            HttpSession session = request.getSession();
            Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
            int numUtil = utilisateur.getNumUtil();
            int qte = 1;
            //Integer.parseInt(request.getParameter("qte"));
            produit = produitDAO.getProduitByNum(numPro);
            System.out.println(produit.getStock());
            if (qte > produit.getStock()) {
                System.out.println("stock insiffusant");
            } else {
                int maxCommande = commandesDao.getCommandes(numUtil).stream().map(c->c.getNumCde()).max(Integer::compare).get();
                ++maxCommande;
                System.out.println("shit"+maxCommande);
                commandesDao.addCommande(new Commande(maxCommande,Date.valueOf(LocalDate.now())), produit, numUtil, qte);
                this.getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
    }
}