package first.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import useful.classes.UtilityFunctions;
import user.User;

/**
 * Servlet implementation class DeconnexionUser
 */
@WebServlet("/DisconnectUser")
public class DisconnectUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisconnectUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//session verification
	      
        User user = UtilityFunctions.getUser(request);
        if(user==null)//user not authenticated         
        {
        	ServletContext sc =getServletConfig().getServletContext();
        	UtilityFunctions.redirectToLogin(sc,request,response);
        	return;
        }
		HttpSession session = request.getSession(false);
		if(session==null)
		session.setAttribute("user", null);
		session.invalidate();
		
		// We redirect the user to the welcome page
		ServletContext sc = getServletConfig().getServletContext();
    	RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/Goodbye.jsp");
    	rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
