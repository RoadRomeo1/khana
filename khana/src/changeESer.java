

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

public class changeESer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String user="root";
String pass="root";
String newmail=request.getParameter("newmail");
String oldmail=request.getParameter("oldmail");
String password=request.getParameter("pass");
String url="jdbc:mysql://localhost:3306/khanna";
String sql="select email,password from data where email='"+oldmail+"' ";
String sql1="update data set email='"+newmail+"' where password='"+password+"' ";
Connection con=null;
Statement st=null;
ResultSet rs=null;
PrintWriter pw=response.getWriter();
int count=0;

try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Started...at changeSer");


con=DriverManager.getConnection(url,user,pass);
System.out.println("Connected at... at ChangeESer");


st=con.createStatement();

rs=st.executeQuery(sql);
System.out.println("query executed");

while(rs.next()) {
if(rs.getString("email").equals(oldmail)&&rs.getString("password").equals(password)){	
	st.executeUpdate(sql1);
    System.out.println("Data updated...at changeSer");
	 pw.println("<script type=\"text/javascript\">");
	 pw.println("alert('You are email has been changed successfully...');");
	 pw.println("location='profile.html';");
	 pw.println("</script>");
     count++;
	 break;
    }
}

if(count==0) {
	 pw.println("<script type=\"text/javascript\">");
	 pw.println("alert('Something went wrong maybe your email or security answer is not correct...');");
	 System.out.println("Error");
	 System.out.println(oldmail);
	 System.out.println(newmail);
	 System.out.println(password);
	 pw.println("location='changeE.html';");
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
