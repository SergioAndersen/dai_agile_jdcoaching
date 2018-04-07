<%-- 
    Document   : affichagePro
    Created on : 2018-4-2, 15:36:17
    Author     : eunicerigo
--%>

<%@page import="metier.Seance"%>
<%@page import="metier.Programme"%>
<%@page import="metier.Profil"%>

<%@page import="java.util.ArrayList"%>
<%@page import="bd.bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Creer Programme </title>
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
                        <li><a href="pageCoach.jsp">Home</a></li>
                        <li><a href="accueil.jsp#testimonials">Apercu</a></li>
                        <li><a href="accueil.jsp#section-contact">Contact</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- Tête -->
        <section id="intro">
            <div class="intro-content">
                <h2>JEAN DAVID COACHING</h2>
                <h3>Information concernant le programme</h3>
            </div>
        </section>

        <!--formulaire inscription-->
        <section id="section-inscription" class="section appear clearfix">
            <div class="container">
                <div class="row mar-bot40">
                    <div class="col-md-offset-3 col-md-6">


                        <div class="section-header">
                            <h2 class="section-heading animated" data-animation="bounceInUp">Consultation des informations concernant le programme</h2>

                        </div>

                        <div class="cform" id="contact-form">
                            <form name="form" method="get"id ="form" action="ServletCreerProgramme"  onsubmit="return verifier()">

                                <div class="field your-name form-group">


                                    <%

                                        ArrayList<Seance> seancelist = (ArrayList<Seance>) session.getAttribute("seancelist");

                                        seancelist.get(1).getPro().getLibellePT();

                                        for (int i = 0; i < 1; i++) {
                                            out.println("Nom de programme:");
                                            out.println("<input type='text' name='titre' id ='titre'value=" + seancelist.get(1).getPro().getLibellePT() + "  class='cform-text' size='40' disabled='disabled' required>");

                                            out.println("<div class='validation'></div>"
                                                    + " </div>"
                                                    + "<div class='field your-name form-group'>"
                                                    + "Description Programme :"
                                                    + "");

                                            //on passe a la description du programme 
                                            out.println("<input type='text' name='description' id ='description' value=" + seancelist.get(1).getPro().getDescriptionPT() + " class='cform-text' size='40'disabled='disabled' required>");

                                        }


                                    %>
                                    <div class="validation"></div>

                                    <div name='genre'>
                                        <%-- aller dans adminmodifstatutclient pour faire cette partie --%>


                                        <%   bd unebd = new bd();
                                            int nbSeance = 0;

                                            nbSeance = seancelist.size();

                                        %>
                                    </div>
                            </form>
                        </div>


                        <%                                int i = 1;

                            for (Seance unseance : seancelist) {

                                out.println("<div id='seance" + i + "'>");
                                out.println("<div id='ajoutS" + i + "'  >");
                                out.println("<form name='form' method='get'id ='form' action='ServletVisuelSeance'  onsubmit='return verifier()'>");
                                out.println("<input type='submit' class='btn-get-started scrollto'name='seanceChoisie' value='" + unseance.getCodeST() + "' >Seance" + i + ":</input>  ");
                                out.println("</form>");
                                out.println(" Categorie de Seance: ");
                                out.println("<input type='text' name='nbrepet" + i + "' id ='nbrepet" + i + "'  class='cform-text' size='40' value='" + unseance.getTypeST().getLibelleTS() + " ' required disabled='disabled'></input>");
                                out.println(" Nom de la Seance: ");
                                out.println("<input type='text' name='nbrepet" + i + "' id ='nbrepet" + i + "'  class='cform-text' size='40' value='" + unseance.getLibelleST() + "' required disabled='disabled'></input>");
                                out.println("Nombre de repetition : <input type='text' name='nbrepet" + i + "' id ='nbrepet" + i + "'  class='cform-text' size='40' value='" + unseance.getNbrepet() + "' required disabled='disabled'></input></div><br><br>");

                                i++;
                            }
                        %>
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

