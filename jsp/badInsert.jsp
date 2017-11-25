<%-- 
    Document   : badInsert
    Created on : Aug 25, 2017, 3:18:40 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wrong insert</title>
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="wrapper">
        <div id="header">
        <h1>Wrong insert!</h1>
        </div>
         <!--Checking if there is a session, and is it having the right attribute -->
    <%
        try {
            if (request.getSession().getAttribute("user").equals("1_true")) {
    %>   
    <!--Everything is good , here is your page! -->   
        <%@include file="pageParts/userNavigation.jsp" %>
        <%    } else {
             %> <%@include file="pageParts/navigation.jsp"%><%

            }
        } catch (Exception e) {
           %><%@include file="pageParts/navigation.jsp" %><%
        }
    %>
        <div id="contentP">
        </div>
            </div>
    </body>
</html>
