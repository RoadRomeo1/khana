<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove User</title>
<link rel="icon" href="images\delete.png" type="image/x-icon"/>
<link rel="stylesheet" href="css\style3.css" />
<link rel="stylesheet" href="css\theme.css">
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Playball' rel='stylesheet' type='text/css'>
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
										<ul class="nav navbar-nav" >
											<li class="menuItem active"><a href="AdminProfile.html">Home</a></li>
											<li class="menuItem"><a href="show.jsp">Show members</a></li>
					                        <li class="menuItem" style="float:right;"><a href="logoutSer">Logout</a></li>
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