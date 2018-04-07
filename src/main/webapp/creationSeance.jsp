

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="metier.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bd.bd"%>
<%-- 
    Document   : creationSeance
    Created on : 27 mars 2018, 13:17:03
    Author     : FLEXICSSS
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>creation d'exercice </title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css" 
                  href="Vlava/js/rs-plugin/css/settings.css" media="screen">
            <link rel="stylesheet" type="text/css" href="Vlava/css/isotope.css" media="screen">
            <link rel="stylesheet" 
                  href="Vlava/css/flexslider.css" type="text/css">
            <link rel="stylesheet" href="Vlava/js/jquery.fancybox.css" type="text/css" 
                  media="screen">
            <link rel="stylesheet" href="Vlava/css/bootstrap.css">
            <link rel="stylesheet" 
                  href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700">
            <link rel="stylesheet" href="Vlava/css/style.css">
            <!-- skin -->
            <link rel="stylesheet" href="Vlava/css/default.css">

            <SCRIPT language="JavaScript"  src="script.js">
            </script>
            <SCRIPT type =text/javascript src =fonction/fonctions.js></SCRIPT>
        </head>

        <body onload="recupererTypeSeance()">
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
                        <li><a href="pageCoach.jsp">Page Coach</a></li>
                        <li><a href="accueil.jsp#testimonials">Apercu</a></li>
                        <li><a href="accueil.jsp#section-contact">Contact</a></li>
                        <li><a href="logout.jsp?close=close">Se Deconnecter</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- TÃªte -->
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
        <%
            String provenance = request.getParameter("provenance");
        %>

        <!--formulaire inscription-->
        <section id="section-inscription" class="section appear clearfix">
            <div class="container">
                <div class="row mar-bot40">
                    <div class="col-md-offset-3 col-md-6">
                        <div class="section-header">
                            <h2 class="section-heading animated" data-animation="bounceInUp">Inscrivez les informations concernant l'exercice</h2>
                            <br>
                            <h4>Les informations suivies d'un astérisque sont obligatoires.</h4>
                        </div>

                        <div class="cform" id="contact-form">
                            <form form method="get">
                                <div id="creerseance"></div>
                                <br>
                                <br>
                                <br>



                                <h1>Création de séance</h1>

                                <p>Choisir un  type séance (*): 

                                    <select id="typeS" required>
                                    </select>
                                </p>

                                <p>Titre de la séance (*):  <input type="text" name="titreS" placeholder="Saisir un titre" class="cform-text" size="40" id="titreS" required></p>
                                <p>Description de la séance : <input type="text" name="description" class="cform-text" size="40" placeholder="Saisir une description" id="descriptionS"></p>




                                <h1>Ajouter des exercices </h1>


                                <p><input type="button" class="btn-get-started scrollto" value="CrÃ©er un nouvel exercice" class="cform-text" size="40" onclick="goToCreationPage('seance')"></p>
                                <br>
                                <br>
                                <br>
                                <br>
                                <div id="choixExo"></div>

                                <p><input type="button" class="btn-get-started scrollto" value="Ajouter un nouvel Exercice" class="cform-text" size="40" onclick="ajouterExo()"></p>




                                <div>
                                    <br>
                                    <br>
                                    <br>
                                    <br>

                                    <p>
                                        <%
                                            out.print("<input type='button' class='btn-get-started scrollto' value='Creer ma seance' onclick='creerSeance(" + provenance + ")'>");
                                            out.print("<input type='button' class='btn-get-started scrollto' size='40'value='Annuler la creation' "
                                                    + "onclick='annulerCreerSeance(" + provenance + ")'>");
                                        %>
                                    </p>
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
                        <li><a href="accueil.jsp">Home</a></li>
                        <li><a href="accueil.jsp#testimonials">Apercu</a></li>
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
</f:view>
