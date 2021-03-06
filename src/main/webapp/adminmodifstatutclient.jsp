<%-- 
    Document   : adminmodifstatutclient
    Created on : 29 mars 2018, 15:01:57
    Author     : wangziqi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="metier.Utilisateur"%>
<%@page import="bd.bd"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier le statut d'un client</title>
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

                    bd bd = new bd();
                    ArrayList<Utilisateur> listeEnHaut = bd.userConnect(i);
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
                            <h2 class="section-heading animated" data-animation="bounceInUp">Les informations de </h2>
                            <h2 class="section-heading animated" data-animation="bounceInUp">
            <%
                String Utimodif = request.getParameter("email");
                session.setAttribute("Utimodifff", Utimodif);
                bd unebd = new bd();
                Utilisateur u = unebd.userInfo(Utimodif);
                                    out.println(u.getNomu() + " " + u.getPrenomu());
                                %>
                            </h2>
                        </div>        
                        <div class="cform" id="contact-form">
                            <form name="modif" action="modifier" method="get">
                                <%
                                    out.println("<P>NOM : " + u.getNomu() + "</P><P>PRENOM : " + u.getPrenomu()
                                            + "</P><P>EMAIL : " + u.getMailu() + "</P><P>GENRE : " + u.getGenreu()
                                            + "</P><P>DATE DE NAISSANCE :" + u.getDatenaissanceu() + "</P><P>TEL : "
                                            + "<input type='text' name='tel' pattern='[0-9]{10}' class='cform-text' size='40' value='"
                                            + u.getTelu() + "'" + "/>" + "</P><P>STATUT ACTUEL : " + u.getStatutu() + "</p>");

                                    out.println("STATUT : <select name='select' class='selectpicker'><option value='" + u.getStatutu() + "'" + "selected>" + u.getStatutu() + "</option>");
                if (u.getStatutu().equals("POTENTIEL")) {
                    out.println("<option value='EN ATTENTE'>EN ATTENTE</option><option value='VALIDE'>VALIDE</option></select>");
                } else if (u.getStatutu().equals("EN ATTENTE")) {
                    out.println("<option value='VALIDE'>VALIDE</option></select>");
                } else {
                    out.println("</select>");
                }
            %>
                                <br><br>
                                <input  type="submit" name="submit" value="modifier" class="btn-get-started scrollto"/>
                            </form>
                        </div>

                        <a href="retourLstCL.jsp?retour=retour">Retour à liste client</a>
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
