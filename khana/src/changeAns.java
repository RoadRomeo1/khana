

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class changeAns extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter pw=response.getWriter();
	response.setContentType("text/html");
	
	String user="root";
	String pass="root";
	String newPass=request.getParameter("newpass");
	String ConfirmPass=request.getParameter("confirm");
	String email=request.getParameter("email");
	String url="jdbc:mysql://localhost:3306/khanna";
	ResultSet rs=null;
    Connection con=null;
    Statement st=null;
    String sql="select * from data where email='"+email+"'  ";
    String sql1="update data set password='"+ConfirmPass+"' where email='"+email+"' ";
    
    try {
	
    	Class.forName("com.mysql.jdbc.Driver");
    	System.out.println("Started at changeAns");
    	
    	con=DriverManager.getConnection(url, user, pass);
    	System.out.println("Connected at ChangeAns");
    	
    	st=con.createStatement();
    	
    	rs=st.executeQuery(sql);
    	System.out.println("data Arrived fro data-table");
    	
       
    	if(rs==null) {
    		 System.out.println("Wrong email entered at part-1");
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Please Enter Right and Registered Email');");
			 pw.println("location='Forgot.html';");
	 		 pw.println("</script>");
       
    	}
    	else {
			while (rs.next()) {
			  if(rs.getString("email").equals(email)) {
				  st.executeUpdate(sql1);
				  System.out.println("Data updated");
				  pw.println("<script type=\"text/javascript\">");
				  pw.println("alert('Your Security Answer has been changed Successfully');");
				  pw.println("location='welcome.html';");
			 	  pw.println("</script>");
			 	  break;
		       	  }
				
			else {
				 System.out.println("Wrong email entered part-2");
				 pw.println("<script type=\"text/javascript\">");
				 pw.println("alert('Please Enter Right and Registered Email');");
				 pw.println("location='Forgot.html';");
		 		 pw.println("</script>");
	          	}
			}
		}
    	
   
    	con.close();
    	rs.close();
    	st.close();
    	
	}  catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (Exception e) {
     e.printStackTrace();
     }
	
	
		
		
	}

}
