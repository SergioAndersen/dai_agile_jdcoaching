<%-- 
    Document   : listeSeance
    Created on : 5 avr. 2018, 09:32:45
    Author     : Sergio
--%>
<%@page import="metier.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bd.bd"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Affichage liste exo</title>
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
        <link rel="stylesheet" href="Vlava/skin/default.css" type="text/css"/>

        <SCRIPT language="JavaScript"  src="script.js"></script>
        <script type="text/javascript" src="fonction/fonctions.js"><!--comment--></script>
    </head>
     <body onload="recuperationSeance()">

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
                        <li><a href="pageCoach">Page Coach</a></li>
                        <li><a href="accueil.jsp#testimonials">Apercu</a></li>
                        <li><a href="accueil.jsp#section-contact">Contact</a></li>
                        <li><a href="logout.jsp?close=close">Se Deconnecter</a></li>
                    </ul>
                </div>
            </div>
        </div>
        

        <!-- Bienvenue -->
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
                <h3>Bienvenue!</h3>
            </div>
        </section>
                
                
                 <section id="section-inscription" class="section appear clearfix">
            <div class="container">
                <div class="row mar-bot40">
                    
                    <div class="section-header"></div>
          
        <h1>Liste des séances</h1>
        
        <form method="get" action="ServletVisuelSeance">
            <div id="listeSeance"></div>
            <input type="submit" lass="btn btn-theme" value="Visualiser cette séance">
        </form>
        
        </div>
                </div>
        
        </section>
        
        
    </body>
</html>
