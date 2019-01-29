import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Logged extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");
		try {
			Connection con=null;
			Statement st=null,st1=null;
            ResultSet rs=null,rs1=null;
			PrintWriter pw=response.getWriter();
	        String username=request.getParameter("user");	
			String password=request.getParameter("pass");
	        String user="root";
			String pass="root";
			String url="jdbc:mysql://localhost:3306/khanna";
		    String name1=null,passcode1=null;
			
			Class.forName("com.mysql.jdbc.Driver");
	     	
			System.out.println("username= " + username);
			System.out.println("password= " + password);
			
			
			con=DriverManager.getConnection(url, user, pass);
			
			
			st=con.createStatement();
		    st1=con.createStatement();
		    
		    String sql1="select * from data";
		    rs1=st1.executeQuery(sql1);
		  
		 
		    while (rs1.next()) {
			    if(rs1.getString("name").equals(username)&&rs1.getString("password").equals(password)) {
			    	name1=rs1.getString("name");
			    	passcode1=rs1.getString("password");
			    	break;
			  }
			   
		    	}
		    
			if(name1!=null) {
			    HttpSession session=request.getSession();
				session.setAttribute("name1",name1);
	            System.out.println("password matched!");
				request.getRequestDispatcher("profile.html").include(request, response);
				pw.println("<h1>" + "Welcome " + name1 + "</h1>");
			  
			}
			
		    else if(name1==null) {
				System.out.println("Wrong username or password");
				 pw.println("<script type=\"text/javascript\">");
				 pw.println("alert('UserName or Password incorrect');");
				 pw.println("location='welcome.html';");
				 pw.println("</script>");
				
			}
			System.out.println(name1);
			System.out.println(passcode1);
				
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		catch (ClassNotFoundException e) {
	     e.printStackTrace();
		}
		
		catch (Exception e) {
		e.printStackTrace();
		}
		

	}

}
