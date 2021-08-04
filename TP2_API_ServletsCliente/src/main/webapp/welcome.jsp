<%-- 
    Document   : welcome
    Created on : 4 ago. 2021, 00:55:50
    Author     : Facu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <% 
            try {
                if(!(boolean)request.getSession().getAttribute("session")) response.sendRedirect("logout.jsp"); 
            } catch (Exception e) {
                response.sendRedirect("logout.jsp");
            }
        %>
        <h1>Bienvenido al servicio</h1>
        <h2>Hola <% out.println(session.getAttribute("nombre")); %></h2>
        
        <form action="http://localhost:8088/Clase6/logout.jsp">
            <input type="submit" value="Salir">
        </form>
    </body>
</html>