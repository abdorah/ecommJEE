package com.ecomm.servelt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecomm.DAO.FamilleDAO;
import com.ecomm.javaBeans.Famille;

@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Accueil() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FamilleDAO familles = new FamilleDAO();
		List<Famille> familleList = null;
		try {
			familleList = familles.getFamilles();

			request.setAttribute("list", familleList);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
