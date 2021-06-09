package com.ecomm.servelt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Produits")
public class Produits extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String familleName= (String) request.getParameter("familleName");
        System.out.println(familleName);


        this.getServletContext().getRequestDispatcher("/WEB-INF/shop.jsp").forward(request, response);
    }
}
