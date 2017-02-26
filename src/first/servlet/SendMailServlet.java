package first.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mail.*;

import user.User;

import useful.classes.UtilityFunctions;

@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MailServer ms ;

    public void init(ServletConfig config)throws ServletException {
    	super.init(config);
    	ms = MailServer.newInstance();
    }


    public void service(HttpServletRequest request, HttpServletResponse response)
    		throws IOException, ServletException {
    	
    	//session verification
    	int a=0;
      
        User user = UtilityFunctions.getUser(request);
        if(user==null)//user not authenticated        
        {
        	ServletContext sc =getServletConfig().getServletContext();
        	UtilityFunctions.redirectToLogin(sc,request,response);
            return;
        }

        response.setContentType("text/html");        
        PrintWriter out = response.getWriter();
        String from =  user.getMail();
        if(from==null)
        {
        	  ServletContext sc =getServletConfig().getServletContext();
        	// he has a session but a bad one, invalidate and kick
        	request.getSession().invalidate();
        	UtilityFunctions.redirectToLogin(sc,request,response);
        	return;
        }
        
        
        String to =  request.getParameter("to");
        String subject =  request.getParameter("subject");
        String message =  request.getParameter("message");	
        if(to==null || subject==null|| message==null)
        {
        	 ServletContext sc =getServletConfig().getServletContext();
        	//bad form redirect to form
        	 UtilityFunctions.redirectToLogin(sc,request,response);
            return;
        }
        
        ms.sendMessage(from, to,subject, message);
        out.println("Message Sent successfully");
	
        out.println("<br>"); 
        out.println("From    : " + from);
        out.println("<br>"); 
        out.println("To    : " + to);
        out.println("<br>"); 
        out.println("Subject      : " + subject);
        out.println("<br>"); 
        out.println("Message : " + message);

        out.println("<br>"); 
        out.println("<br>"); 

        UtilityFunctions.printFrontPageLink(out);
        out.close();
    }
}