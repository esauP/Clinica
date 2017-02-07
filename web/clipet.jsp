<%@page import="pojo.*;"%>
<%@page import="data.*;"%>
<%@page import="java.util.*;"%>
<%@page import="logicadao.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Rainbow Children Hospital html5 Bootstrap web Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />
<!-- css -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="css/jcarousel.css" rel="stylesheet" />
<link href="css/flexslider.css" rel="stylesheet" />
<link href="js/owl-carousel/owl.carousel.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->


</head>
<body>
<div id="wrapper">
	<!-- start header -->
	<header>
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <div class="container-fluid" >

                    </div>
                </div>
                <div class="navbar-collapse collapse ">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.html">Home</a></li>
						<li><a href="log.jsp">Citas</a></li>
						<li><a href="events.html">Events </a></li>
                        <li><a href="portfolio.html">Gallery</a></li>
                        <li><a href="Fees.html">Fees</a></li>
                        <li><a href="contact.html">Contact</a></li>
                    </ul>
                </div>
            </div>
        </div>
	</header>
        <body>
	<!-- end header -->
	<section class="callaction">
		<br>
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Buscar cliente...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">Go!</button>
						</span>
					</div><!-- /input-group -->
				</div><!-- /.col-lg-6 -->
				<div>
				<table cellSpacing="1" cellPadding="8" width="770" align="center" border="0" class="table table-striped">
					<tr>
						<td>
							<div class="input-group">
							  <span class="input-group-addon">id_person</span>
							  <input type="text" class="form-control" placeholder="DNI" aria-describedby="basic-addon1">
							</div>
						</td>
						<td>
							<div class="input-group">
							  <span class="input-group-addon">name</span>
							  <input type="text" class="form-control" placeholder="nombre" aria-describedby="basic-addon1">
							</div>
						</td>
						<td>
							<div class="input-group">
							  <span class="input-group-addon">adress</span>
							  <input type="text" class="form-control" placeholder="direccion" aria-describedby="basic-addon1">
							</div>
						</td>
					</tr>

					<tr>
						<td>
							<div class="input-group">
							  <span class="input-group-addon">telephone </span>
							  <input type="text" class="form-control" placeholder="telefono" aria-describedby="basic-addon1">
							</div>
						</td>
						<td>
							<div class="input-group">
							  <span class="input-group-addon">email</span>
							  <input type="text" class="form-control" placeholder="email" aria-describedby="basic-addon1">
							</div>
						</td>
					</tr>

				</table>
			</div>
    </div>
	</div><!-- /.container -->

	</section>
			<div id="content" class="container">
                <table summary ="Listado de Citas"  cellSpacing="1" cellPadding="8" width="770" align="center" border="0" class="table table-striped">
                    <tr valign ="middle" align="center">

                        <%
                            Ldate ld = new Ldate();
                            ArrayList<Dates> arraydate = ld.getDatesDay();
                        %>
                        <td id = "colchones" colspan="8"><b>Citas registradas del d&iacutea</b></td>
                    </tr>
                    <tr valign=" middle" align="center" id="cabecera">
                        <td>Dia</td><td>Hora</td><td>Cliente</td><td>Observaciones</td>
                    </tr>

                    <%
                        for (int i = 0; i < arraydate.size(); i++) {
                            Dates dd = (Dates) arraydate.get(i);
                    %>
                    <tr align="center" id="Usuarios">
                        <td><%=dd.getDate()%></td>
                        <td> <%=dd.getHour()%> </td>
                        <td> <%=dd.getPerson()%> </td>
                        <td> <%=dd.getObservations()%> </td>
                    </tr>
                    <%
                        }

                    %>

                </table>

            </div>

	<section class="callaction">
	<div class="container">

	</div>
	</section>
	<section id="content">


	<div class="container">

	</div>
	</section>
	<div class="testimonial-area">
    <div class="testimonial-solid">
        <div class="container">


        </div>
    </div>
</div>
	<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="widget">
					<h5 class="widgetheading">Our Contact</h5>
					<address>
					<strong>Rainbow Hospital Inc</strong><br>
					JC Main Road, Near Silnile tower<br>
					 Pin-21542 NewYork US.</address>
					<p>
						<i class="icon-phone"></i> (123) 456-789 - 1255-12584 <br>
						<i class="icon-envelope-alt"></i> email@domainname.com
					</p>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="widget">
					<h5 class="widgetheading">Quick Links</h5>
					<ul class="link-list">
						<li><a href="#">Latest Events</a></li>
						<li><a href="#">Terms and conditions</a></li>
						<li><a href="#">Privacy policy</a></li>
						<li><a href="#">Career</a></li>
						<li><a href="#">Contact us</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="widget">
					<h5 class="widgetheading">Latest posts</h5>
					<ul class="link-list">
						<li><a href="#">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</a></li>
						<li><a href="#">Pellentesque et pulvinar enim. Quisque at tempor ligula</a></li>
						<li><a href="#">Natus error sit voluptatem accusantium doloremque</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="widget">
					<h5 class="widgetheading">Recent News</h5>
					<ul class="link-list">
						<li><a href="#">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</a></li>
						<li><a href="#">Pellentesque et pulvinar enim. Quisque at tempor ligula</a></li>
						<li><a href="#">Natus error sit voluptatem accusantium doloremque</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="sub-footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="copyright">
						<p>
							<span>&copy; Rainbow Site All right reserved. Template By </span><a href="http://webthemez.com" target="_blank">WebThemez</a>
						</p>
					</div>
				</div>
				<div class="col-lg-6">
					<ul class="social-network">
						<li><a href="#" data-placement="top" title="Facebook"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#" data-placement="top" title="Twitter"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#" data-placement="top" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
						<li><a href="#" data-placement="top" title="Pinterest"><i class="fa fa-pinterest"></i></a></li>
						<li><a href="#" data-placement="top" title="Google plus"><i class="fa fa-google-plus"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	</footer>
</div

<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<!-- javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- script que permite al usuario cerrar el dialogo cuando haga click fuera de el-->
<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
<script src="js/jquery.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.fancybox.pack.js"></script>
<script src="js/jquery.fancybox-media.js"></script>
<script src="js/portfolio/jquery.quicksand.js"></script>
<script src="js/portfolio/setting.js"></script>
<script src="js/jquery.flexslider.js"></script>
<script src="js/animate.js"></script>
<script src="js/custom.js"></script>
<script src="js/owl-carousel/owl.carousel.js"></script>
</body>
</html>
