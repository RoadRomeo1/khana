

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class profileSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		
		
		response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        HttpSession session=request.getSession(false);
        
        if(session!=null) {
        	String name=(String)session.getAttribute("name1");
            request.getRequestDispatcher("profile.html").include(request, response);
        	pw.print("<h1>"+" Welcome " +name+ " Again " + "</h1>");
        
            
				}
        
        else {
        	
		   	RequestDispatcher rd=request.getRequestDispatcher("Login.html");
        	rd.include(request, response);
        	pw.println("<script type=\"text/javascript\">");
		    pw.println("alert('Please Login first');");
		    pw.println("location='Login.html';");
		    pw.println("</script>");        
        }
pw.close();	
	}

}
