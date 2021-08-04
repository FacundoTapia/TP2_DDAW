<%-- 
    Document   : logout
    Created on : 4 ago. 2021, 00:56:10
    Author     : Facu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Out</title>
    </head>
    <body>
        <% session.invalidate(); %>
        <h1>Se cerro la sesion :(</h1>
    </body>
</html>
