package first.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.*;
import javax.servlet.http.*;
import mail.*;


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
    	MailServer ms=MailServer.newInstance();
    	Vector<Message> mess=ms.readAllMessages(to);
	 
    }
}