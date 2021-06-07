// package com.ecomm.servelt;

// import java.io.IOException;
// import java.sql.SQLException;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;

// import com.DAO.DoctorDAO;
// import com.DAO.UtilisateurDAO;
// import com.ecomm.DAO.ClientDAO;
// import com.ecomm.javaBeans.Client;
// import com.javaBeans.HomeData;
// import com.javaBeans.Utilisateur;


// @WebServlet("/Login")
// public class Login extends HttpServlet {
// 	private static final long serialVersionUID = 1L;
       
//     public Login() {
//         super();
//     }

//     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//     	HttpSession session = request.getSession();
    	
//     	if(session.getAttribute("client")!=null) {
//     		Client client = (Client) session.getAttribute("client");
//     		/* String  accountType = client.getAccountType() ;
//             if(accountType.equals("doctor")) {
//         		ClientDAO doctorDAO = new ClientDAO();
//         		HomeData homeData;
//         		homeData = doctorDAO.getData();
//         		request.setAttribute("homeData",homeData);
//             	this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
//             }
//             else if(accountType.equals("patient")) {
//             	this.getServletContext().getRequestDispatcher("/WEB-INF/home_patient.jsp").forward(request, response);
//             }
// 			*/
//     	}
    	
// 		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
// 	}

// 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 		String email = request.getParameter("email");
// 		String password = request.getParameter("password");
		
// 		UtilisateurDAO userDAO = new UtilisateurDAO();
// 		Utilisateur user = null ;
		
// 		try {
// 			user=userDAO.checkLogin(email, password);
// 		} catch (SQLException e) {
			
// 			e.printStackTrace();
// 		}
		
// 		if(user != null) {
// 			HttpSession session = request.getSession();
//             session.setAttribute("user", user);
            
//             //V�rifiez si est un m�decin ou patient et dirige chacun vers sa espace
//             String  accountType = user.getAccountType() ;
//             if(accountType.equals("doctor")) {
//         		DoctorDAO doctorDAO = new DoctorDAO();
//         		HomeData homeData;
//         		homeData = doctorDAO.getData();
//         		request.setAttribute("homeData",homeData);
//             	this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
//             }
//             else if(accountType.equals("patient")) {
//             	this.getServletContext().getRequestDispatcher("/WEB-INF/home_patient.jsp").forward(request, response);
//             }
            				
// 		}
// 		else {
// 			String message = "Email et/ou Mot de passe incorrect(s)";
//             request.setAttribute("message", message);
//             doGet(request, response);                
// 		}
// 	}
// }
