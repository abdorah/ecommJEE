package com.ecomm.servelt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecomm.DAO.UtilisateurDAO;
import com.ecomm.javaBeans.Utilisateur;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String email = request.getParameter("email");
		String password = request.getParameter("password");
		UtilisateurDAO userDAO = new UtilisateurDAO();
		Utilisateur user = null ;

		try {
			user=userDAO.checkLogin(email, password);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			String  accountType = user.getAccountType() ;
			if(accountType.equals("administrateur")) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/homeAdmin.jsp").forward(request, response);
			}
			else if(accountType.equals("client")) {

				//int numProduit= (int)(request.getAttribute("numpro"));


				//this.getServletContext().getRequestDispatcher("/Commandes").forward(request, response);
				this.getServletContext().getRequestDispatcher("/Produits").forward(request, response);
			}

		}
		else {
			String message = "Email et/ou Mot de passe incorrect(s)";
			request.setAttribute("message", message);
			doGet(request, response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		/*Cookie loginCookie = new Cookie("user",user);
		//setting cookie to expiry in 30 mins
		loginCookie.setMaxAge(30*60);
		response.addCookie(loginCookie);

		 */
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		//int numProduit= Integer.parseInt(request.getParameter("numPro"));
		String familleName= request.getParameter("familleName");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+familleName);
         //request.setAttribute("numpro",familleName);
		//ServletContext servletcontext = getServletContext();
		//servletcontext.setAttribute("familleName", familleName);
		HttpSession session=request.getSession();
		session.setAttribute("familleName",familleName);

	}
}