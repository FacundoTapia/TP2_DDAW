<%-- 
    Document   : NuestraEmpresa
    Created on : 4 ago. 2021, 01:29:24
    Author     : Facu
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
            try {
                if(!(boolean)request.getSession().getAttribute("session")) response.sendRedirect("logout.jsp"); 
            } catch (Exception e) {
                response.sendRedirect("logout.jsp");
            }
        %>
        <h1>Nuestra Empresa!</h1>
    </body>
</html>
