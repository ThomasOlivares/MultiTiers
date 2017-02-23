package first.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mail.*;

@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MailServer ms ;

    public void init(ServletConfig config) {
    	ms = MailServer.newInstance();
    }


    public void service(HttpServletRequest request, HttpServletResponse response)
    		throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String from =  request.getParameter("from");
        String to =  request.getParameter("to");
        String subject =  request.getParameter("subject");
        String message =  request.getParameter("message");	    
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

        out.println("<br> <a href=\"http://localhost:8080/mail/index.html\"> Go back to index.html</a>");
        out.close();
    }
}