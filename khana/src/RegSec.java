

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
/*import java.sql.ResultSet;
*/import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;



public class RegSec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String user="root";
      String pass="root";
      String ques=request.getParameter("ques");
      String ans=request.getParameter("ans");
      String  key=request.getParameter("pass");
      /*ResultSet rs=null;*/
      Statement st=null;
      Connection con=null;
      String sql="update data set secQuestion='"+ques+"' where password='"+key+"' "; 
      String sql1="update data set secAnswer='"+ans+"' where password='"+key+"' ";
      String url="jdbc:mysql://localhost:3306/khanna";
      PrintWriter pw=response.getWriter();
      	
      
   try {   
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Started...at RegSec");
      
      con=DriverManager.getConnection(url, user, pass);
   System.out.println("Connected...at RegSec");   
      
   st=con.createStatement();
   
   if(ques!=null&&ans!=null&&key!=null) {
	     st.executeUpdate(sql);
	     st.executeUpdate(sql1);
	     System.out.println("Data Saved...at RegSec");
	     pw.println("<script type=\"text/javascript\">");
		 pw.println("alert('Now You are Sccessfully Registered');");
		 pw.println("location='welcome.html';");
 		 pw.println("</script>");
	    }
   
   else {
	     pw.println("<script type=\"text/javascript\">");
		 pw.println("alert('Please add Security Details First:');");
		 pw.println("location='secQuestion.html';");
		 pw.println("</script>");
	   
   }
   
   }
  
   catch (ClassNotFoundException e) {
	e.printStackTrace();
}
   catch (SQLException e) {
	e.printStackTrace();
}
      
      
	}

}
