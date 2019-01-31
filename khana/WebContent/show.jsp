<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import=" java.sql.*" %>


<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="images\data.png" type="image/x-icon"/>
<link rel="stylesheet" href="css\style3.css" />
<link rel="stylesheet" href="css\theme.css">
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Playball' rel='stylesheet' type='text/css'>
<title>Data</title>
<style>
table {
	border: 1px solid black;
	outline-color: black;
	table-layout: fixed;
	width: 100%;
	border-collapse: collapse;
	
}

table td {
	width: 50%;
	border: 1px solid black;
	padding: 10px;
	text-align: center;
}

table caption {
	font-style: italic;
}


.button2{
background-color: gray;
border-radius: 5px;
border-color:black;
background-color: #333;
font-size: 25px;
cursor: pointer;
height:50px;
width:190px;
font-style: color=white;

}

.button2:hover {
	background-color: #cc580c;
}


</style>
</head>
<body>

<header>

	<div class="banner row" id="banner">		
			<div class="parallax text-center" style="background-image: url(http://wowthemes.net/demo/leroy/img/dummy1.jpg);">
				<div class="parallax-pattern-overlay">
					<div class="container text-center" style="height:600px;padding-top:170px;">
					<h2 class="intro wow zoomIn" wow-data-delay="0.4s" wow-data-duration="0.9s">Khana</h2>
					</div>
				</div>
			</div>
		</div>	
	
	<div class="menu">
			<div class="navbar-wrapper">
				<div class="container">
					<div class="navwrapper">
						<div class="navbar navbar-inverse navbar-static-top">
							<div class="container">
								<div class="navArea">
									<div class="navbar-collapse collapse">
										<ul class="nav navbar-nav">
											<li class="menuItem active"><a href="AdminProfile.html">Home</a></li>
											<li class="menuItem"><a href="show.jsp">Show members</a></li>
					                        <li class="menuItem"><a href="logoutSer">Logout</a></li>
					                    </ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>	
		</header>


<%   	Connection con=null;
	    ResultSet rs=null;
		Statement st=null;
		
	try {
		
	 
	String url="jdbc:mysql://localhost:3306/khanna";
	String user="root";
	String pass="root";
	String sql="select * from data";
    
	
	Class.forName("com.mysql.jdbc.Driver");
	
	con=DriverManager.getConnection(url, user, pass);
	
	
	st=con.createStatement();
	rs=st.executeQuery(sql);
	%>
	
	<center>
	<br><br>
	<table border="5px" bordercolor="black">
	<tr>
	 <th>
	 <% out.println("Name"); %>
	 </th>
	 <th>
	 <%out.println("Email"); %>
	 </th>
	 <th>
	 <%out.println("Password"); %>
	 </th>
	 <th>
	 <%out.println("Security Question"); %>
	 </th>
	 <th>
	 <%out.println("Security Answer"); %>
	 </th>
	 </tr>
	 </table>
	 </center>
	 <% 
 while(rs.next()){
	 
	 String name=rs.getString("name");
	 String email=rs.getString("email");
	 String password=rs.getString("password");
	 String secQuestion=rs.getString("secQuestion");
	 String secAnswer=rs.getString("secAnswer");
	 %>
	 <center>
	 <table border="5px" bordercolor="black">
	 <tr>
	 <td>
	 <% out.println(name); %>
	 </td>
	 <td>
	 <%out.println(email); %>
	 </td>
	 <td>
	 <%out.println(password); %>
	 </td>
	 <td>
	 <%out.println(secQuestion); %>
	 </td>
	 <td>
	 <%out.println(secAnswer); %>
	 </td>
	 </tr>
	 </table>
	 </center>
<%
 }
	%>
	<% 
	
	if(con!=null) {
		con.close();
		st.close();
	}

	}
	catch(ClassNotFoundException e) {
		e.printStackTrace();
	} 
	
	
	catch (SQLException e) {
		e.printStackTrace();
	}
	
	
%>


<br><br>

<center><input type="button"  class="button2"  value="Remove user" onclick="location='removeUser.jsp';">&nbsp&nbsp&nbsp&nbsp<input type="button" class="button2" value="Add new admin" onclick="location='addAdmin.html';"></center>
	


	<!--footer-->
	<div>
	<section class="footer" id="footer">
	
	<p class="text-center">
	 &copy; Copyright <br>
	 Developed by Himanshu Vyas
	</p>
	</section>
	</div><!--wrapper end-->
	
	
<!--Javascripts-->
<script src="js/jquery.js"></script>
<script src="js/modernizr.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/menustick.js"></script>
<script src="js/parallax.js"></script>
<script src="js/easing.js"></script>
<script src="js/wow.js"></script>
<script src="js/smoothscroll.js"></script>
<script src="js/masonry.js"></script>
<script src="js/imgloaded.js"></script>
<script src="js/classie.js"></script>
<script src="js/colorfinder.js"></script>
<script src="js/gridscroll.js"></script>
<script src="js/contact.js"></script>
<script src="js/common.js"></script>

<script type="text/javascript">
jQuery(function($) {
$(document).ready( function() {
  //enabling stickUp on the '.navbar-wrapper' class
	$('.navbar-wrapper').stickUp({
		parts: {
		  0: 'banner',
		  1: 'aboutus',
		  2: 'specialties',
		  3: 'gallery',
		  4: 'feedback',
		  5: 'contact'
		},
		itemClass: 'menuItem',
		itemHover: 'active',
		topMargin: 'auto'
		});
	});
});
</script>

</body>
</html>
	 