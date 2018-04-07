<%-- 
    Document   : logout
    Created on : 29 mars 2018, 19:21:39
    Author     : evaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (request.getParameter("close").equals("close")) {
                session.invalidate();

                out.println("<script LANGUAGE='JavaScript'>");
                out.print("alert('Réussir de déconnecter!!!')");
                out.println("</script>");
            }

            response.setHeader("Refresh", "0;url=accueil.jsp");//retour à l'accueil.jsp
%>
    </body>
</html>
