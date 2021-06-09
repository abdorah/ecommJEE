package com.ecomm.servelt;

import com.ecomm.DAO.ProduitDAO;
import com.ecomm.javaBeans.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Produits")
public class Produits extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
List<Produit> produits=null;
    ProduitDAO ProduitsDao=new ProduitDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


           try {
               String familleName= (String) request.getParameter("familleName");
               if(familleName!=null){
               produits=ProduitsDao.getPoduitsByFamilleNom(familleName);
               request.setAttribute("produits",produits);
               System.out.println(familleName);
               }
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }

        this.getServletContext().getRequestDispatcher("/WEB-INF/shop.jsp").forward(request, response);


    }
}
