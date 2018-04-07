<%-- 
    Document   : retourLstCL
    Created on : 31 mars 2018, 14:57:10
    Author     : evaba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>retourLstCL</title>
    </head>
    <body>
        
                <%
            if (request.getParameter("retour").equals("retour")) {
                session.removeAttribute("mailmodif");
                session.removeAttribute("statut");
                session.removeAttribute("tel");
            }

            response.setHeader("Refresh", "0;url=listeTtClient.jsp");//retour à l'listeTtClient.jsp
%>
    </body>
</html>
