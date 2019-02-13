

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
import javax.swing.plaf.synth.SynthSeparatorUI;

public class changeSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String user="root";
    String pass="root";
    String url="jdbc:mysql://localhost:3306/khanna";
    String answer=request.getParameter("answer");
    String newpass=request.getParameter("newpass");
    String secid=request.getParameter("secid");
    String confirm=request.getParameter("confirm");
    String sql="select secAnswer from data where secAnswer='"+answer+"'";
    String sql1="update data set password='"+confirm+"' where secAnswer='"+answer+"' ";
    ResultSet rs=null;
    Connection con=null;
    Statement st=null;
    PrintWriter pw=response.getWriter();
    
    try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Started at changeSer...");
		
		con=DriverManager.getConnection(url, user, pass);

		System.out.println("Connected...at changeSer");
		
		st=con.createStatement();
		
		 System.out.println("data coming...at changeSer");
		    
		 
		 
	
			 rs=st.executeQuery(sql);
			 
			
			   if(rs==null) {
			     System.out.println("Wrong answer");
    			 pw.println("<script type=\"text/javascript\">");
    			 pw.println("alert('Please Enter Right Answer.');");
    			 pw.println("location='change.html';");
    	 		 pw.println("</script>");
            
			}
			 
			else {System.out.println("we successfully crossed if section");
	    
						while(rs.next()) {
                  			System.out.println("we are in while loop");
	    		if(rs.getString("secAnswer").equals(answer)) {
	    		     st.executeUpdate(sql1);
	    		     System.out.println("Data updated...at changeSer");
	    			 pw.println("<script type=\"text/javascript\">");
	    			 pw.println("alert('Your password has been changed successfully...');");
	    			 pw.println("location='welcome.html';");
	    	 		 pw.println("</script>");
                     break;
	    		}
	    		
	    	}
						System.out.println("end");
			}
			   
		    
	
	       
	
		
		con.close();
		rs.close();
		st.close();
    }		  	
     catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
    catch (Exception e) {
		e.printStackTrace();
	}
    
    
    
    }

}
