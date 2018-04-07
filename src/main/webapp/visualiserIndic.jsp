<%-- 
    Document   : visualiserIndic
    Created on : 29 mars 2018, 17:24:32
    Author     : evaba
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="metier.Utilisateur"%>
<%@page import="bd.bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Indicateur de client</title>
        <link rel="stylesheet" type="text/css" 
              href="Vlava/js/rs-plugin/css/settings.css" media="screen">
        <link rel="stylesheet" type="text/css" href="Vlava/css/isotope.css" media="screen">
        <link rel="stylesheet" 
              href="flexslider.css" type="text/css">
        <link rel="stylesheet" href="Vlava/js/jquery.fancybox.css" type="text/css" 
              media="screen">
        <link rel="stylesheet" href="Vlava/css/bootstrap.css">
        <link rel="stylesheet" 
              href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700">
        <link rel="stylesheet" href="Vlava/css/style.css">
        <link rel="stylesheet" href="Vlava/css/icon-component.css">
        <!-- skin -->
        <link rel="stylesheet" href="Vlava/css/default.css">
    </head>
    <body>
        <section id="header" class="appear"></section>
        <div class="navbar navbar-fixed-top" role="navigation" 
             data-0="line-height:100px; height:100px; background-color:rgba(0,0,0,0.3);" 
             data-300="line-height:60px; height:60px; background-color:rgba(5, 42, 62, 1);">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="fa fa-bars color-white"></span>
                    </button>
                </div>

                <!-- Menu en haut -->
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav" data-0="margin-top:20px;" data-300="margin-top:5px;">
                        <li><a href="pageadmin.jsp">Home</a></li>
                        <li><a href="#parallax1">Apercu</a></li>
                        <li><a href="accueil.jsp#section-contact">Contact</a></li>
                        <li><a href="logout.jsp?close=close">Deconnecter</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <section id="intro">
            <div class="intro-content">
                <h2>JEAN DAVID COACHING</h2>
                <%
                    String idut = (String) session.getAttribute("id");

                    int i = Integer.parseInt(idut);

                    bd bd = new bd();
                    ArrayList<Utilisateur> listeEnHaut = bd.userConnect(i);
                    for (Utilisateur u : listeEnHaut) {
                        out.println("<h3>Bonjour ! " + u.getNomu() + " " + u.getPrenomu() + "</h3>");
                    }
                %>  
            </div>
        </section>


        <div class="container">
            <div class="row mar-bot40">
                <div class="section-header">
                    <br><br>
                    <h2 class="section-heading animated" data-animation="bounceInUp">Indicateur sur le status de client</h2>
                </div>

                <br><br>
                <div class="col-md-3"></div>
                  <div class="col-md-5">
                <ul>
                    <li>Le nombre des clients total: 
                    <%  ArrayList<String> indic = bd.indicClientStatu();
                            out.println(indic.get(2)+"<br><br>");
                    %>
                    </li>

                    <li>Le nombre et le pourcentage des clients validés:
                    <%
                        out.println(indic.get(3));
                            out.println("(" + indic.get(0) + "%)<br><br>");
                    %>
                    </li>

                    <li>Le nombre et le pourcentage des clients en attente:
                    <%
                        out.println(indic.get(4));
                            out.println("(" + indic.get(1) + "%)<br><br>");
                    %>
                    </li>

                    <li>Le nombre et pourcentage des clients potentiels:  
                    <%
                        out.println(indic.get(6));
                            out.println("(" + indic.get(5) + "%)<br><br>");
                    %>
                    </li>
                </ul>

                    </div>
            </div>
        </div>

                <section id="parallax1" class="section" data-stellar-background-ratio="0.5">
                    <div class="container">
                        <div class="row appear stats">
                            <!--total-->
                            <div class="col-md-4">
                                <div class="align-center color-white txt-shadow">
                                    <div class="icon">
                                        <i class="fa fa-coffee fa-5x"></i>
                                    </div>
                                    <strong id="counter-coffee" class="number">
                                        <%
                                            out.println(indic.get(2));
                                        %>
                                    </strong><br>
                                    <span class="text">Clients total</span>
                                </div>
                            </div>
                            <!--valide-->      
                            <div class="col-md-4">
                                <div class="align-center color-white txt-shadow">
                                    <div class="icon">
                                        <i class="fa fa-heart fa-5x"></i>
                                    </div>
                                    <strong id="counter-heart" class="number">
                                        <%
                                            out.println(indic.get(3));
                                            out.println("(" + indic.get(0) + "%)");
                                        %>
                                    </strong><br>
                                    <span class="text">Clients Validés</span>
                                </div>
                            </div>
                            <!--en attente-->      
                            <div class="col-md-4">
                                <div class="align-center color-white txt-shadow">
                                    <div class="icon">
                                        <i class="fa fa-clock-o fa-5x"></i>
                                    </div>
                                    <strong id="counter-clock" class="number">
                                        <%
                                            out.println(indic.get(4));
                                            out.println("(" + indic.get(1) + "%)");
                                        %>
                                    </strong><br>
                                    <span class="text">Clients en attente</span>
                                </div>
                            </div>  
                        </div>
                    </div>
                </section>


         
        <section id="footer" class="section footer">
            <div class="container">
                <div class="row animated opacity mar-bot20" data-andown="fadeIn" data-animation="animation">
                    <div class="col-sm-12 align-center">
                        <ul class="social-network social-circle">
                            <li><a href="#" class="icoRss" title="Rss"><i class="fa fa-rss"></i></a></li>
                            <li><a href="#" class="icoFacebook" title="Facebook"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" class="icoTwitter" title="Twitter"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" class="icoGoogle" title="Google +"><i class="fa fa-google-plus"></i></a></li>
                            <li><a href="#" class="icoLinkedin" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
                        </ul>
                    </div>
                </div>
                <div class="row align-center mar-bot20">
                    <ul class="footer-menu">
                        <li><a href="pageadmin.jsp">Home</a></li>
                        <li><a href="#parallax1">Apercu</a></li>
                        <li><a href="accueil.jsp#section-contact">Contact</a></li>
                    </ul>
                </div>
                <div class="row align-center copyright">
                    <div class="col-sm-12">
                        <p>Copyright &copy; All rights reserved</p>
                    </div>
                </div>
            </div>
        </section>

    </body>
</html>
