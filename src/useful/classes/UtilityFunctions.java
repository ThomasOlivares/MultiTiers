package useful.classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import user.User;


public class UtilityFunctions {
	public static void redirectToLogin(ServletContext sc,HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
        RequestDispatcher rd = sc.getRequestDispatcher("/accueil.jsp"); //TODO proper url
        rd.include(request, response);
	}
	public static void printFrontPageLink(PrintWriter out )
	{
		out.println("<br> <a href=\"menu.jsp\"> Go back to the menu</a>");
	}
	
	
	public static User getUser(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);//so that we don't generate one if we don't have one
	    if(session == null)
	    {
	    	return null;
	    }
	    //check that he didn't just obtain a rogue session
	    User identClient = (User)session.getAttribute("user");
	    if(identClient ==null)
	    {
	    	return null;
	    }
	    else return identClient;
	}
	

}
