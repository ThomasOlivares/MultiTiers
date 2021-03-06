package first.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import useful.classes.UtilityFunctions;
import user.GestionUsers;
import user.User;

/**
 * Servlet implementation class AutentificationUser
 */
@WebServlet("/AutentificationUser")
public class AutentificationUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final int validityPeriod = 10;
       
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
		
		//we should not get here by get method, only post so redirect !
		ServletContext sc =getServletConfig().getServletContext();
    	UtilityFunctions.redirectToLogin(sc,request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		String allowCookies = request.getParameter("cookies");
		
		GestionUsers gestion = new GestionUsers();
		ArrayList<User> listeUsers = GestionUsers.newInstance();
		
		if (login == null || mdp == null || listeUsers.isEmpty()){
			ServletContext sc = getServletConfig().getServletContext();
        	RequestDispatcher rd = sc.getRequestDispatcher("/Erreur.jsp");
        	rd.include(request, response);
		}
		User user = gestion.isUser(login, mdp);
		if (user != null){
			// we store if the user allow cookies, and create a cookie if he does
			user.setAllowCookies(allowCookies != null);
			if (allowCookies != null){
				String value = user.getLogin() + "/" + user.getMdp();
				Cookie userId = new Cookie("userId", value);
				response.addCookie(userId);
			}
			
			createSession(request, user);
			
			ServletContext sc = getServletConfig().getServletContext();
        	RequestDispatcher rd = sc.getRequestDispatcher("/Menu");
        	rd.include(request, response);
		}
		else{
			ServletContext sc = getServletConfig().getServletContext();
        	RequestDispatcher rd = sc.getRequestDispatcher("/Error");
        	rd.include(request, response);
		}
	}
	
	public static void createSession(HttpServletRequest request, User user){
		HttpSession session = request.getSession();
		
		// we invalidate the session after a period of inactivity
		session.setMaxInactiveInterval(validityPeriod);
		
		session.setAttribute("user", user);
	}

}
