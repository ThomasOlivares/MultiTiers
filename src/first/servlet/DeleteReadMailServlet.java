package first.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.MailServer;

import user.User;
import useful.classes.UtilityFunctions;

/**
 * Servlet implementation class DeleteReadMailServlet
 */
@WebServlet("/DeleteReadMailServlet")
public class DeleteReadMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MailServer ms ;

    public void init(ServletConfig config) {
    	ms = MailServer.newInstance();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReadMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    	
    	String to =   user.getMail();
    	if(to==null)
         {
         	// he has a session but a bad one, invalidate and kick
    		ServletContext sc =getServletConfig().getServletContext();
    		request.getSession().invalidate();
         	UtilityFunctions.redirectToLogin(sc,request,response);
         	return;
         }
    	String return_=ms.removeMessages(to);
    	out.println("Deleting all read emails:");
    	out.println(return_);
    	out.println("<br> <a href=\"http://localhost:8080/mail/index.html\"> Go back to index.html</a>");
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
