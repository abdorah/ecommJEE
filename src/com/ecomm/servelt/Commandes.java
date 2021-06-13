package com.ecomm.servelt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;

import com.ecomm.DAO.CommandeDAO;
import com.ecomm.DAO.ProduitDAO;
import com.ecomm.DAO.UtilisateurDAO;
import com.ecomm.javaBeans.Produit;
import com.ecomm.javaBeans.Utilisateur;
import com.mysql.cj.util.Util;

@WebServlet("/Commandes")
public class Commandes extends HttpServlet {
    String actionBuyorvalidate="nothin";


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        if (action == null) {
            System.out.println("no action");
            String quantite=request.getParameter("qte");

            int numProduitamodifier= Integer.parseInt(request.getParameter("numpr"));
            System.out.println("teeeeeesssssssssssssssssstttttttttttttttttiiiiiiii"+numProduitamodifier+"klkklkk"+quantite);
            String[] quantites = request.getParameterValues("qte");
            String[] numPros = request.getParameterValues("numpr");
            System.out.println("teeeeeesssssssssssssssssstttttttqqqttttttttttaaaaaa");
            Arrays.stream(quantites).forEach(System.out::println);
            System.out.println("teeeeeesssssssssssssssssstttttttttNNNNttttttttaaaaaa");
            Arrays.stream(numPros).forEach(System.out::println);
            CommandeDAO commandeDAO = new CommandeDAO();
            ProduitDAO produitDAO = new ProduitDAO();
            HttpSession session = request.getSession();
            for (int i = 0; i < numPros.length; i++) {
                try {
                    commandeDAO.addCommande(produitDAO.getProduitByNum(Integer.parseInt(numPros[i])), ((Utilisateur)session.getAttribute("user")).getNumUtil(), Integer.parseInt(quantites[i]));
                } catch (NumberFormatException | SQLException e) {
                    e.printStackTrace();
                }
            }
doGet_showproducts_in_cart(request, response);
        } else {
            if(action.equalsIgnoreCase("modify")){

            }
            if (action.equalsIgnoreCase("buy")) {
                actionBuyorvalidate="buy";
                doGet_Buy(request, response);
                doGet_showproducts_in_cart(request, response);
            }
            if (action.equalsIgnoreCase("remove")){
                doGet_remove(request,response);
               // doGet_showproducts_in_cart(request, response);
            }

                if(action.equalsIgnoreCase("valider")){

                System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjj");
            } else {
                doGet_showproducts_in_cart(request, response);
            }
        }

    }







    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
        /*
        if(page.equalsIgnoreCase("cart")){
                int vale = commandesDao.addCommande(produit, numUtil,qte);

                System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjj"+vale);
            }
         */

        // int numPro = (int)request.getAttribute("numpro");
        // response.sendRedirect("/Produits");
        // this.getServletContext().getRequestDispatcher("/Produits").forward(request,
        // response);
    }







    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

        /*Cookie loginCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    loginCookie = cookie;
                    break;
                }
            }
        }
        if (loginCookie != null) {
            response.addCookie(loginCookie);
            this.getServletContext().getRequestDispatcher("/Produits").forward(request, response);
        }

         */
doGet(request,response);
    }

    protected void doGet_remove(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        List<Integer>nums= (List<Integer>) session.getAttribute("cart");
       int numppro= Integer.parseInt(request.getParameter("numppro"));
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == numppro) {
                nums.remove(i);
            }
        }
        try {
            this.getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    protected void doGet_showproducts_in_cart(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter("page");
        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkk" + page);
        String action = request.getParameter("action");
        if (action == null|| page.equals("addtocart")||page.equals("cart")) {
            int numPro =0;
            if (action ==  null) {
                numPro = Integer.parseInt(request.getParameter("numpr"));
            } else {
                numPro = Integer.parseInt(request.getParameter("id"));
            }
        
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmaaaaaa" + numPro);
        ProduitDAO produitDAO = new ProduitDAO();

        CommandeDAO commandesDao = new CommandeDAO();
        try {
            Produit produit = produitDAO.getProduitByNum(numPro);
            HttpSession session = request.getSession();
            Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
            int numUtil = utilisateur.getNumUtil();
            int qte = 1;
            System.out.println(produit.getStock());
            if (qte > produit.getStock()) {
                System.out.println("stock insiffusant");
            } else {
                List<Integer>nums= (List<Integer>) session.getAttribute("cart");
               //HttpSession session2 = request.getSession(true);
                List<Produit>productsselected=new ArrayList<Produit>();

                for (int p: nums) {

                 productsselected.add(produitDAO.getProduitByNum(p));

                }
                productsselected.forEach(p-> System.out.println(p.getNomPro()+"++"+p.getPuPro()));
                request.setAttribute("productsselected",productsselected);
                /*if(actionBuyorvalidate.equalsIgnoreCase("cart")){
                    int vale = commandesDao.addCommande(produit, numUtil,qte);

                    System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrr"+vale);
                }

                 */


                try {
                    this.getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp").forward(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    }

    protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produit produit = new Produit();
        HttpSession session = request.getSession();

        if (session.getAttribute("cart") == null) {
            List<Integer> productsnums = new ArrayList<Integer>();
            productsnums.add(Integer.valueOf(request.getParameter("id")));
            for (int i : productsnums) {
                System.out.println("this is the buyed list listtttttttt" + i);
            }
            session.setAttribute("cart", productsnums);
        } else {
            List<Integer> productsnums= (List<Integer>) session.getAttribute("cart");
            int index = isExisting(Integer.parseInt(request.getParameter("id")), productsnums);
            if (index == -1) {
                productsnums.add(Integer.parseInt(request.getParameter("id")));
                for (int i : productsnums) {
                    System.out.println("this is the buyed list list" + i);
                }
            }
            session.setAttribute("cart", productsnums);

        }

    }

    private int isExisting(int id, List<Integer> productsnums) {
        for (int i = 0; i < productsnums.size(); i++) {
            if (productsnums.get(i) == id) {
                return i;
            }
        }
        return -1;
    }
    private void validercomande(Produit produit, int numUtil, int qte){
        CommandeDAO commandesDao=new CommandeDAO();
        try{
            commandesDao.addCommande(produit,numUtil,qte);
            if(commandesDao.addCommande(produit,numUtil,qte)>0){
                System.out.println("commande aded succesfuly");
            }
            else {
                System.out.println("commande not aded succesfuly!!!!!!!");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}