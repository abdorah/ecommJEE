package com.ecomm.servelt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecomm.DAO.ProduitDAO;
import com.ecomm.javaBeans.Produit;

@WebServlet("/Produits")
public class Produits extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie loginCookie = null;
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("JSESSIONID")){
    			loginCookie = cookie;
    			break;
    		}
    	}
    	}
    	if(loginCookie != null){
        	response.addCookie(loginCookie);
    	}
        List<Produit> produits=null;
        ProduitDAO ProduitsDao=new ProduitDAO();
        try {
            HttpSession session=request.getSession();
            String familleName= session.getAttribute("familleName").toString();
            System.out.println("bbbbbbbbbbbbbbbbbbbbbbb"+familleName);
            if(familleName!=null){
                produits=ProduitsDao.getPoduitsByFamilleNom(familleName);
                request.setAttribute("produits",produits);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/shop.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}