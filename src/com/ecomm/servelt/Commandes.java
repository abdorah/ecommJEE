package com.ecomm.servelt;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            System.out.println("no action");
        } else {
            if (action.equalsIgnoreCase("buy")) {
                doGet_Buy(request, response);
                doGet_get(request, response);
            } else {
                doGet_get(request, response);
            }
        }

        // int numPro = (int)request.getAttribute("numpro");
        // response.sendRedirect("/Produits");
        // this.getServletContext().getRequestDispatcher("/Produits").forward(request,
        // response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

    protected void doGet_get(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter("page");
        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkk" + page);
        if (page.equals("addtocart")) {
            try {
                this.getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        int numPro = Integer.parseInt(request.getParameter("id"));
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

                int maxCommande = commandesDao.getCommandes(numUtil).stream().map(c -> c.getNumCde())
                        .max(Integer::compare).orElse(0);
                ++maxCommande;
                System.out.println("shitiiiiiiiiiiiii" + maxCommande);
                commandesDao.addCommande(new Commande(maxCommande, Date.valueOf(LocalDate.now())), produit, numUtil,
                        qte);
                // this.getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp").forward(request,
                // response);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
}