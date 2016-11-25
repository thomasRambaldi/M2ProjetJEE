package fr.gestionnaire.annuaire;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet{
	public Login(){

	}

	// initialisation de la servlet
	public void init(ServletConfig c) throws ServletException {

	}

	// destruction la servlet
	public void destroy() {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Person p = (Person) request.getSession().getAttribute("person");
		request.getRequestDispatcher("dataPerson.jsp").forward(request, response);
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		HttpSession maSession = request.getSession();
		String mail = request.getParameter("login");
		String password = request.getParameter("psw");
		Person personData = null;
		Dao dao = new Dao();
		dao.setUrl("jdbc:mysql://localhost:3306/projetjee?useSSL=false");
		dao.setUser("root");
		dao.setPassword("");
		dao.setDriverName("com.mysql.jdbc.Driver");

		try { personData = dao.findPerson(mail); } catch (SQLException e) {e.printStackTrace();}

		if( personData == null || ! personData.getPassword().equals(password)){
			maSession.setAttribute("error", "Email ou mot de passe invalide");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		maSession.setAttribute("person", personData);
		maSession.setAttribute("error", null);
		request.getRequestDispatcher("dataPerson.jsp").forward(request, response);	

		//		p.setId(pm.getPersons().size());
		//		PersonError pe = null;
		//		try {
		//			pe = pm.check(p);
		//		} catch (Exception e1) {
		//			// TODO Auto-generated catch block
		//			e1.printStackTrace();
		//		}
		//
		//		if(pe.isValid()){
		// Appeler une page JSP depuis une servlet
		//			maSession.setAttribute("person", p);
		//			try {
		//				pm.save(p);
		//			} catch (Exception e) {
		//				e.printStackTrace();
		//			}
		//			maSession.setAttribute("pm", pm);
		//			request.getRequestDispatcher("person.jsp").forward(request, response);
		//		}
		//		else{
		//			maSession.setAttribute("personError", pe);
		//			request.getRequestDispatcher("edition.jsp").forward(request, response);
		//		}



	}

	public void service(  ) { 

	}
}