<%-- 
    Document   : modifiermdptoclient
    Created on : 30 mars 2018, 15:34:49
    Author     : 21104333
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="metier.Utilisateur"%>
<%@page import="bd.bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>modifiermdptoclient</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
        <!-- skin -->
        <link rel="stylesheet" href="Vlava/css/default.css">

        <SCRIPT type ="text/javascript" src ="fonction/fonctions.js"></SCRIPT>
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
                        <li><a href="pageClient.jsp">Home</a></li>
                        <li><a href="#section-inscription">Apercu</a></li>
                        <li><a href="accueil.jsp#section-contact">Contact</a></li>
                        <li><a href="logout.jsp?close=close">Deconnecter</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- Tête -->
        <section id="intro">
            <div class="intro-content">
                <h2>JEAN DAVID COACHING</h2>
                <h2>
                    <%
                        String ida = (String) session.getAttribute("id");

                        int id = Integer.parseInt(ida);

                        bd unebd = new bd();
                        ArrayList<Utilisateur> lstu = unebd.userConnect(id);
                        for (Utilisateur u : lstu) {
                            out.println("<h3>Bonjour ! " + u.getNomu() + " " + u.getPrenomu() + "</h3>");
                        }

                    %>
                </h2>
            </div>
        </section>
        <!--formulaire inscription-->
        <section id="section-inscription" class="section appear clearfix">
            <div class="container">
                <div class="row mar-bot40">
                    <div class="col-md-offset-3 col-md-6">
                        <div class="section-header">
                            <h2 class="section-heading animated" data-animation="bounceInUp">Modifiez votre mot de passe</h2>
                        </div>
                        <div class="cform" id="contact-form">
                            <form action="servletmdp" method="post">
                                <p>Entrez votre ancien mot de passe:</p>

                                <% for (Utilisateur u : lstu) {
                                        String mdp = u.getMdpu();

                                        out.println("<p><input type='text' name='mdpancien' id='mdpancien' required onkeyup='verifMDP(" + mdp + ")'> </p>");
                                    }
                                %>


                                <p>Entrez votre nouveau mot de passe :</p>
                                <p><input type="text" name="mdpnouveau" value="" required> </p>
                                <p><input type='submit' id ='bouton' value='Envoyer' class="btn-get-started scrollto"/></p>

                                <p name="eunice" id ="eunice"> </p>

                            </form>
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
                        <li><a href="pageClient.jsp">Home</a></li>
                        <li><a href="#section-inscription">Apercu</a></li>
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

