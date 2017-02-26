package first.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mail.*;

import user.User;
import useful.classes.UtilityFunctions;

@WebServlet("/ReceiveMailServlet")
public class ReceiveMailServlet extends HttpServlet {

    /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	MailServer ms ;

    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
	ms = MailServer.newInstance();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException 
    {
    	//session verification
      
        User user = UtilityFunctions.getUser(request);
        if(user==null)//user not authenticated         
        {
        	ServletContext sc =getServletConfig().getServletContext();
        	UtilityFunctions.redirectToLogin(sc,request,response);
        	return;
        }
    	
    	
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	String to =  user.getMail();
    	if(to==null)
        {
        	// he has a session but a bad one, invalidate and kick
    		ServletContext sc =getServletConfig().getServletContext();
        	request.getSession().invalidate();
        	UtilityFunctions.redirectToLogin(sc,request,response);
        	return;
        }
    	
    	//let's get all the messages
    	Vector<Message> messages=ms.readAllMessages(to);
    	String mess=Integer.toString(messages.size())+" messages inbox for the address: "+to +"\n";
    	for(int i=0;i<messages.size();i++)
    	{
    		mess+=messages.elementAt(i).toString()+"\n";
    	}
    	//print everything
    	out.println("<h1>Received mails:</h1>");
    	out.println(mess);
    	UtilityFunctions.printFrontPageLink(out);
        out.close();
    }
}