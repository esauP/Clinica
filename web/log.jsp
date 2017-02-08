<%@page import="pojo.*;"%>
<%@page import="data.*;"%>
<%@page import="java.util.*;"%>
<%@page import="logicadao.*"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Clínica Veterinaria</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="" />
        <meta name="author" content="http://webthemez.com" />
        <!-- css -->
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/fancybox/jquery.fancybox.css" rel="stylesheet">
        <link href="css/jcarousel.css" rel="stylesheet" />
        <link href="css/flexslider.css" rel="stylesheet" />
        <link href="css/style.css" rel="stylesheet" />

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
              <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
            <![endif]-->

    </head>
    <body>

        <%
            String userForm = (String) session.getAttribute("session.user");
            if (userForm == null) {
                response.sendRedirect("error.html");
            }
        %>
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
                            <a class="navbar-brand" href="index.html"><img src="img/logo.png" alt="logo"/></a>
                        </div>
                        <div class="navbar-collapse collapse ">
                            <ul class="nav navbar-nav">
                                <li><a href="index.html">Home</a></li>
                                <li class="active"><a href="about.html">About Us</a></li>
                                <li><a href="events.html">Events </a></li>
                                <li><a href="portfolio.html">Gallery</a></li>
                                <li><a href="Fees.html">Fees</a></li>
                                <li><a href="contact.html">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </header><!-- end header -->
            <section id="inner-headline">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <h2 class="pageTitle">About Us</h2>
                            <b> <h1>Usuario</h1> </b>
                        </div>
                    </div>
                </div>
            </section>

            <div id="content" class="container">
                <table summary ="Listado de Citas"  cellSpacing="1" cellPadding="8" width="770" align="center" border="0" class="table table-striped">
                    <tr valign ="middle" align="center">

                        <%
                            LPerson lp = new LPerson();
                            Ldate ld = new Ldate();
                            ArrayList<Dates> arraydate = ld.getDatesDay();
                            Person persona = new Person();
                        %>
                        <td id = "colchones" colspan="8"><b>Citas registradas del d�a</b></td>
                    </tr>
                    <tr valign=" middle" align="center" id="cabecera">
                        <td>Dia</td><td>Hora</td><td>Cliente</td><td>Observaciones</td><td>Seleccionar</td>
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
                        <td><% persona = lp.getPerson(dd.getPerson());  %> <img src='img/seleccionar.gif'> </a></td>
                         <td> <a href="FrontController?res=tutorias.jsp?pid=<%=p.getIdProfesor()%>&name=<%=p.getNombre()%>"><img src='img/seleccionar.gif'> </a></td>
                    </tr>
                    <%
                        }

                    %>

                </table>
                    First name: <input type="text" name="fname" value="<%=persona.getNamePer() %>">
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
        </div>
        <a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
        <!-- javascript
            ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
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
    </body>
</html>
