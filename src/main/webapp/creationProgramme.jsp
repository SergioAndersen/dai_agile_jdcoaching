<%-- 
    Document   : CreerProgramme
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
                        <li><a href="pageCoach">Page Coach</a></li>
                        <li><a href="accueil.jsp#testimonials">Apercu</a></li>
                        <li><a href="accueil.jsp#section-contact">Contact</a></li>
                        <li><a href="logout.jsp?close=close">Se Deconnecter</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- Tête -->
        <section id="intro">
            <div class="intro-content">
                <h2>JEAN DAVID COACHING</h2>
                <h3>Créer un nouveau programme</h3>
            </div>
        </section>

        <!--formulaire inscription-->
        <section id="section-inscription" class="section appear clearfix">
            <div class="container">
                <div class="row mar-bot40">
                    <div class="col-md-offset-3 col-md-6">


                        <div class="section-header">
                            <h2 class="section-heading animated" data-animation="bounceInUp">Inscrivez les informations concernant votre programme</h2>
                            <h4>Les informations suivies d'un astérisque sont obligatoires.</h4>
                        </div>

                        <div class="cform" id="contact-form">
                            <form name="form" method="get"id ="form" action="ServletCreerProgramme"  onsubmit="return verifier()">

                                <div class="field your-name form-group">
                                    Titre Programme : (*)

                                    <%
                                        Programme rep = null;

                                        rep = (Programme) session.getAttribute("programme");

                                        if (rep != null) {
                                            out.println("<input type='text' name='titre' id ='titre'value=" + rep.getLibellePT() + "  class='cform-text' size='40' disabled='disabled' required>");

                                        } else {

                                            out.println("<input type='text' name='titre' id ='titre'  class='cform-text' size='40' required>");

                                        }

                                        out.println("<div class='validation'></div>"
                                                + " </div>"
                                                + "<div class='field your-name form-group'>"
                                                + "Description Programme : (*)"
                                                + "");

                                        //on passe a la description du programme 
                                        if (rep != null) {

                                            out.println("<input type='text' name='description' id ='description' value=" + rep.getDescriptionPT() + " class='cform-text' size='40'disabled='disabled' required>");
                                        } else {
                                            out.println("<input type='text' name='description' id ='description'  class='cform-text' size='40' required>");
                                            out.println("Combien de seances contiendra ce programme");
                                            out.println("<input type='number' name='nbSeance' id ='nbSeance'  class='cform-text' size='40' required>");

                                        }

                                    %>
                                    <div class="validation"></div>
                                </div>
                                <div name='genre'>
                                    <%-- aller dans adminmodifstatutclient pour faire cette partie --%>
                                    Profil du programme : (*)

                                    <%   bd unebd = new bd();
                                        int nbSeance = 0;
                                        if (rep != null) {
                                            String p = (String) session.getAttribute("profilProgramme");
                                            String u = unebd.recupNomProfil(Integer.parseInt(p));

                                            out.print("<H4>" + u + "</H4");

                                            Object ca = session.getAttribute("nbSeance");
                                            String co = ca.toString();
                                            nbSeance = Integer.parseInt(co);

                                        } else {

                                            ArrayList<Profil> list = unebd.recuperationProfil();

                                            out.println("<select name='ProfilProgramme' id ='ProfilProgramme'class='cform-text'  required>");
                                            for (Profil u : list) {
                                                System.out.println(u.getDescriptionPro());
                                                out.println("<option value='" + u.getCodepro() + "'>" + u.getDescriptionPro() + "</option>");
                                            }
                                            out.println("</select>");
                                        }
                                        if (rep != null) {
                                        } else {
                                            out.println("</div>"
                                                    + "<br>"
                                                    + "<br>"
                                                    + "<div>"
                                                    + "<input type='submit' class='btn-get-started scrollto' onClick='ServletCreerProgramme()' value='Creer Programme'   />"
                                                    + "<input type='reset'class='btn-get-started scrollto' value='Effacer'  />");
                                        }
                                    %>
                                </div>
                            </form>
                        </div>

                        <form name='form' method='get'id ='form2' action='ServletCreerProgramme2'  onsubmit='return verifier()'>
                            <%
                                System.out.println("");

                                for (int i = 1; i <= nbSeance; i++) {

                                    out.println("<p id='nbse' name='nbse' value='" + nbSeance + "' hidden> </p>");

                                    out.println("<div id='seance" + i + "'>");
                                    out.println("<div id='ajoutS" + i + "'  >");
                                    out.println("<h3> Seance" + i + " :</h3>");
                                    out.println("Choix de la seance :  (categorie de la seance et nom)");
                                    out.println("<select name='codeS" + i + "' id ='codeS" + i + "'class='form-control-static'> ");

                                    ArrayList<Seance> listSe = unebd.recuperationSeance();

                                    for (Seance se : listSe) {

                                        out.println("<option  value='" + se.getCodeST() + "'>" + se.getTypeST().getLibelleTS() + "---" + se.getLibelleST() + "</option>");
                                    }
                                    out.println("</select>");
                                    String pro = "programme";
                                    out.println("<a href='creationSeance.jsp' target='_blank'> Ajouter une nouvelle seance</a> <br><br>");
                                    out.println("Nombre de repetition : <input type='text' name='nbrepet" + i + "' id ='nbrepet" + i + "' value='2'  class='cform-text' size='40'  required> </div><br><br>");
                                }
                            %>


                            <input type='submit' onClick='ServletCreerProgramme2()' class='btn-get-started scrollto' value='Valider le contenu programme' />

                        </form>
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

