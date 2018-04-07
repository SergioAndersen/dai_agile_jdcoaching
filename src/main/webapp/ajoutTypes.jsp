<%-- 
    Document   : ajoutTypes
    Created on : 3 avr. 2018, 18:25:43
    Author     : evaba
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="metier.TypeS"%>
<%@page import="java.util.ArrayList"%>
<%@page import="metier.Utilisateur"%>
<%@page import="bd.bd"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter categorie</title>
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
                        <li><a href="#section-contact">Apercu</a></li>
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

                    bd unebd = new bd();
                    ArrayList<Utilisateur> listeEnHaut = unebd.userConnect(i);
                    for (Utilisateur u : listeEnHaut) {
                        out.println("<h3>Bonjour ! " + u.getNomu() + " " + u.getPrenomu() + "</h3>");
                    }
                %>
            </div>
        </section>


        <section id="section-contact" class="section appear clearfix">
            <div class="container">
                <div class="row mar-bot40">
                    <div class="col-md-offset-3 col-md-6">
                        <div class="section-header">
                            <h2 class="section-heading animated" data-animation="bounceInUp">La liste des profils</h2>
                        </div>
                        <div class="container">
                            <div class="col-md-1"></div>
                            <div class="col-md-5">
                                <br>
                                <%
                                    ArrayList<TypeS> lstTypes = unebd.recuperationTypeSeance();
                                    for (TypeS ts : lstTypes) {
                                        out.println("<ul><li>" + ts.getLibelleTS() + "</li></ul>");
                                    }
                                %>
                            </div>
                        </div>
                        <br>
                        <div class="cform" id="contact-form">
                            <form action="ajouterTS" method="get" name="ajouterTS">
                                <div class="section-header">
                                    <h2 class="section-heading animated" data-animation="bounceInUp">Ajouter une catégorie</h2>
                                </div>
                                <div class="col-md-7">
                                    <input type="text" name="txtcat" value=""/>
                                </div>
                                <div class="col-md-5">    
                                    <input type="submit" name="submit" value="Ajouter" class="btn-get-started scrollto"/>
                                </div>

                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <!--footer-->
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
                    <li><a href="#section-contact">Apercu</a></li>
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

