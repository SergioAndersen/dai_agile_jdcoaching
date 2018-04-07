<%-- 
    Document   : pageCoach
    Created on : 29 mars 2018, 10:13:30
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
        <title>Page Coach</title>
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
                        <li><a >Page Coach</a></li>
                        <li><a href="accueil.jsp#testimonials">Apercu</a></li>
                        <li><a href="accueil.jsp#section-contact">Contact</a></li>
                        <li><a href="logout.jsp?close=close">Se Deconnecter</a></li>
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

        <section id="section-services" class="section pad-bot30 bg-white">
            <div class="container">

                <div class="row mar-bot40">
                    <div class="col-lg-1"></div>
                    <div class="col-lg-5">

                        <div class="">
                            <a href="creationProgramme.jsp"><h3 class="text-bold">Creer un nouveau programme</h3></a>

                            <a href="afficherProCoach.jsp"><h3 class="text-bold"> Afficher liste programme </h3></a>
                        </div>



                        <div class="">
                            <a href="creationExercice.jsp"><h3 class="text-bold"> Creer un nouvel exercice </h3></a>
                            <a href="afficherListeExo.jsp"><h3 class="text-bold"> Afficher liste Exercice </h3></a>
                        </div>



                        <div class="">  
                            <a href="creationSeance.jsp"><h3 class="text-bold"> creer une nouvelle seance </h3></a>
                            <a href="listeSeance.jsp"><h3 class="text-bold"> Afficher liste Seance </h3></a>
                        </div>

                        <div class="">
                    
                        <a href="ListClient.jsp"><h3 class="text-bold"> Affecter des clients à des programmes </h3></a>
                        
                        
                        </div>
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
                        <li><a href="#">Home</a></li>
                        <li><a href="#testimonials">Apercu</a></li>
                        <li><a href="#section-contact">Contact</a></li>

                    </ul>
                </div>
                <div class="row align-center copyright">
                    <div class="col-sm-12">
                        <p>Copyright &copy; All rights reserved</p>
                    </div>
                </div>
            </div>
        </section>




        <!-- Javascript Library Files -->
        <script src="Vlava/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <script src="Vlava/js/jquery.js"></script>
        <script src="Vlava/js/jquery.easing.1.3.js"></script>
        <script src="Vlava/js/bootstrap.min.js"></script>
        <script src="Vlava/js/jquery.isotope.min.js"></script>
        <script src="Vlava/js/jquery.nicescroll.min.js"></script>
        <script src="Vlava/js/fancybox/jquery.fancybox.pack.js"></script>
        <script src="Vlava/js/skrollr.min.js"></script>
        <script src="Vlava/js/jquery.scrollTo.min.js"></script>
        <script src="Vlava/js/jquery.localScroll.min.js"></script>
        <script src="Vlava/js/stellar.js"></script>
        <script src="Vlava/js/jquery.appear.js"></script>
        <script src="Vlava/js/jquery.flexslider-min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8HeI8o-c1NppZA-92oYlXakhDPYR7XMY"></script>

        <!-- Contact Form JavaScript File -->
        <script src="Vlava/contactform/contactform.js"></script>

        <!-- Template Main Javascript File -->
        <script src="Vlava/js/main.js"></script>

    </body>
</html>