package first.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.GestionUsers;
import mail.MailServer;
import mail.User;

/**
 * Servlet implementation class AutentificationUser
 */
@WebServlet("/AutentificationUser")
public class AutentificationUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutentificationUser() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		
		GestionUsers gestion = new GestionUsers();
		ArrayList<User> listeUsers = GestionUsers.newInstance();
		
		if (login == null || mdp == null || listeUsers.isEmpty()){
			ServletContext sc = getServletConfig().getServletContext();
        	RequestDispatcher rd = sc.getRequestDispatcher("/erreur.jsp");
        	rd.include(request, response);
		}
		
		if (gestion.isUser(login, mdp)){
			HttpSession session = request.getSession(false);
			User actuel = new User(login, mdp);
			session.setAttribute("user", actuel);
			ServletContext sc = getServletConfig().getServletContext();
        	RequestDispatcher rd = sc.getRequestDispatcher("/menu.jsp");
        	rd.include(request, response);
		}
		else{
			ServletContext sc = getServletConfig().getServletContext();
        	RequestDispatcher rd = sc.getRequestDispatcher("/erreur.jsp");
        	rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
