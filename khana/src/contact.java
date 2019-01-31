

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text.html");
      
      try {
    	  Connection con=null;
    	  Statement st=null;
    	  String user="root";
    	  String pass="root";
    	  String url="jdbc:mysql://localhost:3306/khanna";
    	  String name=request.getParameter("name");
    	  String email=request.getParameter("email");
    	  String message=request.getParameter("comment");
    	  String sql="insert into contact values('"+name+"','"+email+"','"+message+"')";
    	  
    	  Class.forName("com.mysql.jdbc.Driver");	
    	  PrintWriter pw=response.getWriter();
    	  
    	  System.out.println("Strted at Contact");
    	  
    	  con=DriverManager.getConnection(url,user,pass);
    	  
    	  System.out.println("Conneted at Contact");
    	  
    	  st=con.createStatement();
    	  
    	  st.executeUpdate(sql);
    	  
    	  System.out.println("Responce recorded");
    	  
    	     pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Thanks,you are message has been recorded');");
			 pw.println("location='welcome.html';");
	 		 pw.println("</script>");
	 		 
	 		 con.close();
	 		 st.close();
      }
      catch (ClassNotFoundException e) {
  		System.out.println("Error");
  	} catch (SQLException e) {
       System.out.println("here");   
      }
      
      }

}
