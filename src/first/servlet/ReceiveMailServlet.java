package first.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mail.*;

@WebServlet("/ReceiveMailServlet")
public class ReceiveMailServlet extends HttpServlet {

    /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	MailServer ms ;

    public void init(ServletConfig config) {
	ms = MailServer.newInstance();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException 
    {
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	String to =  request.getParameter("to");    	
    	String return_=ms.removeMessages(to);
    	out.println("Suppression des messages deja lus:");
    	out.println(return_);
    	out.println("<br> <a href=\"http://localhost:8080/mail/index.html\"> Go back to index.html</a>");
        out.close();
    }
}