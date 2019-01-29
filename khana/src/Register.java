

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    
    try {
    	
    	
    	Connection con=null;
    	Statement st=null;
		ResultSet rs=null;
    	String user="root";
    	String pass="root";
    	String url="jdbc:mysql://localhost:3306/khanna";
    	String name=request.getParameter("name");
    	String email=request.getParameter("email");
    	String password=request.getParameter("password");    	
    	
    	String sql="insert into data (name,email,password) values('"+name+"','"+email+"','"+password+"')";
    	String sql1="select * from data";
    	int count=0;
    	
    	
    	Class.forName("com.mysql.jdbc.Driver");
     	PrintWriter pw=response.getWriter();
        
     	
	    System.out.println("started...at Register");
    	
    	con=DriverManager.getConnection(url, user, pass);
    	System.out.println("Connected...at Register");
    	
    	st=con.createStatement();
    	
    	rs=st.executeQuery(sql1);
    	
    	while(rs.next()) {
    		if(rs.getString("name").equals(name)&&rs.getString("email").equals(email)&&rs.getString("password").equals(password)) {
    			System.out.println("User Already Exists");
    		     pw.println("<script type=\"text/javascript\">");
    			 pw.println("alert('You are already exist may be you want to Sign in');");
    			 pw.println("location='welcome.html';");
    	 		 pw.println("</script>");
    	 		 count++;
    	         break;		 
    			   }
    	}
    	
    	
    	if(count==0) {
    	
    		st.executeUpdate(sql);
    	    System.out.println("Data Saved...at Register");
            pw.println("<script type=\"text/javascript\">");
	        pw.println("alert('Please Add Security Details Also:');");
	        pw.println("location='secQuestion.html';");
	        pw.println("</script>");
    	}
    	
    	
    }
    catch (ClassNotFoundException e) {
		System.out.println("Error");
	} catch (SQLException e) {
		e.printStackTrace();
	}
    
    
	}

}
