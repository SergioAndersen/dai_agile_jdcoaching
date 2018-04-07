<%-- 
    Document   : visualiserSeance
    Created on : 5 avr. 2018, 12:22:36
    Author     : Sergio
--%>

<%@page import="java.util.Map"%>
<%@page import="metier.Exercice"%>
<%@page import="metier.Seance"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Liste des séances</title>
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
    <body>
        <%
            Seance seanceChoisi = (Seance) session.getAttribute("maseance");
        %>
        <form method="get" action="listeSeance.jsp">
            <div id="voirSeance">
                <h1>Informations sur la séance</h1>
                <p>Type de séance : 
                    <%
                        out.println("<input  type = 'text' id = 'typeSchoisie' value='" + seanceChoisi.getTypeST().getLibelleTS() + "' disabled >");
                    %>
                </p>
                <p>Titre de la séance :  
                    <%
                        out.println("<input  type = 'text' name = 'titreS' id = 'titreS' value='"+ seanceChoisi.getLibelleST() + "' disabled required>");
                    %>
                </p>
                <p>Description de la séance : 
                    <%
                        out.println("<input type='text' name='description'  id='descriptionS' value='" + seanceChoisi.getDescriptionST() + "' disabled>");
                    %>
                </p>
            </div>
            <h1>Exercice de la séance</h1>
            <div id="exoChoisi">
                <%
                    for (Map.Entry<Integer, Exercice> entry : seanceChoisi.getMapExo().entrySet()) {
                        out.println("<h2> Exercice " + entry.getKey().toString() + " : " + entry.getValue().getLibelleEx() + "</h2>");
                        out.println("<p>Durée de récupération : " + entry.getValue().getDureeRecup() + "</p>");
                        out.println("<p>Durée de l'exercice : " + entry.getValue().getDureeEx() + "</p>");
                        out.println("<p>Nombre de répétition : " + entry.getValue().getNbRepetitionEx() + "</p>");
                        out.println("<div>");
                        out.println("<object width='425' height='355'>");
                        out.println("<param name='movie' value='" + entry.getValue().getVideo().replace("watch?v=", "v/") + "'></param>");
                        out.println("<param name='wmode' value='transparent'></param>");
                        out.println("<embed  src = '" + entry.getValue().getVideo().replace("watch?v=", "v/") + "' type = 'application/x-shockwave-flash' wmode = 'transparent' width = '425' height = '355'> </embed>");
                        out.println("</object>");
                        out.println("</div>");
                    }
                %>
            </div>
            <p>
                <input type="button" value="Retour" onclick="">
            </p>
        </form>
    </body>
</html>
