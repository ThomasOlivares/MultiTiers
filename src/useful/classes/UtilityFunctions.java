package useful.classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import first.servlet.AutentificationUser;
import user.GestionUsers;
import user.User;


public class UtilityFunctions {
	public static void redirectToLogin(ServletContext sc,HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
        RequestDispatcher rd = sc.getRequestDispatcher("/");
        rd.include(request, response);
	}
	public static String printFrontPageLink()
	{
		return "<br> <a href=\"Menu\"> Go back to the menu</a>";
	}
	
	
	public static User getUser(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);//so that we don't generate one if we don't have one
	    if(session == null)
	    {
	    	return getUserByCookie(request);
	    }
	    //check that he didn't just obtain a rogue session
	    User identClient = (User)session.getAttribute("user");
	    if(identClient ==null)
	    {
	    	return null;
	    }
	    else return identClient;
	}
	
	// we check if the user can access the page with a valid identification cookie
	private static User getUserByCookie(HttpServletRequest request){
		// search an id cookie in the request
    	Cookie[] cookies = request.getCookies();
    	Cookie userId = searchCookie(cookies, "userId");
    	if (userId == null){
    		return null;
    	}
    	else{
    		// we get the login and the password from the cookie
    		String cookieValue = userId.getValue();
    		String delims = "[/]+";
    		String[] idUser = cookieValue.split(delims);
    		
    		// we check if the user exist
    		GestionUsers gestion = new GestionUsers();
    		User user = gestion.isUser(idUser[0], idUser[1]);
    		
    		if (user == null){
    			return null;
    		}
    		
    		// we check if the cookie user is still valid
    		if (user.isValid()){
    			AutentificationUser.createSession(request, user);
    			return user;
    		}
    		else{
    			return null;
    		}
    	}
	}
	
	// search a cookie in an array of cookies, return null if not found
	private static Cookie searchCookie(Cookie[] cookies, String cookieName){
		if (cookies != null) 
    	{
    	    for(int i=0; i<cookies.length; i++) 
    	    {
    	        Cookie cookie = cookies[i];
    	        if (cookieName.equals(cookie.getName())) 
    	        {
    	            return cookie;
    	        }
    	    }
    	    return null;
    	}
    	else
    	{
    	    return null;
    	}
	}
	

}
