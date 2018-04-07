<%-- 
    Document   : pageadmin
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
        <title>Page Client</title>
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
                        <li><a href="#">Home</a></li>
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
                <h3>
    <%
        String ida = (String) session.getAttribute("id");
       
        int id = Integer.parseInt(ida);
        
        bd unebd = new bd();
        ArrayList<Utilisateur> lstu = unebd.userConnect(id);
        for (Utilisateur u : lstu) {
                            out.println("<h3>Bonjour ! " + u.getNomu() + " " + u.getPrenomu() + "</h3>");
        }
                    %>
                </h3>
            </div>
        </section>

        <section id="section-inscription" class="section appear clearfix">
            <div class="container">
                <div class="row mar-bot40">
                    <div class="col-md-2"></div>
                    <div class="col-md-5">
                        <div class="section-header">
                            <h2 class="section-heading animated" data-animation="bounceInUp">Voici vos informations basiques</h2>
                        </div>
                        <%
                            for (Utilisateur u : lstu) {
                                out.println("<p>NOM : " + u.getNomu() + "</p>" + "<p>PRENOM : " + u.getPrenomu() + "</p>"
                                        + "<p>MAIL : " + u.getMailu() + "</p>" + "<p>GENRE : " + u.getGenreu() + "</p>"
                                        + "<p>DATE NAISSANCE : " + u.getDatenaissanceu() + "</p>"
                                        + "<p>TEL : " + u.getTelu() + "</p>" + "<p>TYPE : " + u.getTypeu() + "</p>");
                                session.setAttribute("mail", u.getMailu());
                            }
    %>
                    </div>
                    <br><br><br><br>
                    <div class="col-md-2"></div>
                    <div class="col-md-3">
                        <P> <a href="profilSportif.jsp">  Completer votre insciption Sportive </a></P> 

    <P><a href="modifProfilBase.jsp">Mofidier mon profil de Base </a></P>
    
                        <P><a href="profilSportif.jsp"> Mofidier mon profil Sportif </a></P>
    
    <P><a href="modifiermdptoclient.jsp">Modifier mon mot de passe</a></P>
   
                        <P><a href="afficherProgCli.jsp">Visualiser mon programme</a></P>

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
