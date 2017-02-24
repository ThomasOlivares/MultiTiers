package useful.classes;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import user.User;


public class UtilityFunctions {
	public static void redirectToLogin(ServletContext sc,HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
        RequestDispatcher rd = sc.getRequestDispatcher("/SaisieIdentification"); //TODO proper url
        rd.include(request, response); 
        return;
	}
	
	
	public static HttpSession verifyLogedInUser(HttpServletRequest request)
	throws ServletException, IOException
	{
		 HttpSession session = request.getSession(false);//so that we don't generate one if we don't have one
	    if(session == null)
	    {
	    	return null;
	    }
	    //check that he didn't just obtain a rogue session
	    User identClient = (User)session.getAttribute("Identification");
	    if(identClient ==null)
	    {
	    	return null;
	    }
	    else return session;
	}
	

}
