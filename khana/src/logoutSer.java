

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class logoutSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter pw=response.getWriter();
   
		
		HttpSession session=request.getSession();
        session.invalidate();
	    pw.println("<script type=\"text/javascript\">");
        pw.println("alert('You have Successfully Logged out');");
        pw.println("location='welcome.html';");
        pw.println("</script>");        

        
        pw.close();
   
	}

}
