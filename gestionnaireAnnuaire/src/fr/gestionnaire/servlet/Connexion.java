package fr.gestionnaire.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gestionnaire.annuaire.Person;

// Peut on utiliser une servlet générique

//@WebServlet(
//		name = "productServlet",
//		description = "Product Servlet",
//		urlPatterns = { "/product/*", "*.prod" },
//		initParams = {
//				@WebInitParam(name = "param1", value = "value1",
//						description = "description1"),
//		},
//		loadOnStartup = 5
//)

@WebServlet("/Connexion")
public class Connexion extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public Connexion(){
		super();
	}

	public void init(ServletConfig c) throws ServletException {
		//		String jdbc = c.getInitParameter("jdbc.url");
		//		bs = new Business(jdbc);
	}

	// destruction la servlet
	public void destroy() {
		//		bs.close();
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		traitement(request, response);
	}

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		traitement(request, response);
	}


	public void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String login = request.getParameter("loginuser");
		String pwd = request.getParameter("pwduser");

		Person user = new Person();
		user.setMail(login);
		user.setPassword(pwd);

		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ResultLogin.jsp");
		dispatcher.forward(request, response);

		//		try{
		//			Class.forName("com.mysql.jdbc.Driver");
		//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjee?useSSL=false");
		//			Statement st=con.createStatement();
		//			ResultSet rs=st.executeQuery("select * from Personne;");
		//
		//			while (rs.next()){
		//				if (login.equals(rs.getString("login")) && pwd.equals(rs.getString("pwd"))) 
		//					System.out.println("Login success");
		//				else
		//					System.out.println("Login Failed");
		//			}
		//
		//			con.close();
		//
		//		}
		//
		//		catch (Exception e) {
		//
		//			System.out.println("ERROR :"+e.getMessage());
		//
		//		}


		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/projetjee?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,userName,password);
			PreparedStatement st = conn.prepareStatement("SELECT idPers, idGroup, NomPers, PrenomPers, MailPers, WebPers,"
				+ " NaissancePers, MdpPers FROM personne WHERE mailPers =  " + "'"+login+"'");
			st.executeQuery();
			ResultSet rs = st.getResultSet();
			
			System.out.println("REUSSI");
			conn.close();
			System.out.println("FINI !!!");
		} catch (Exception e) {
			System.out.print("Error : " +e.getMessage());
		}
	} 


}
