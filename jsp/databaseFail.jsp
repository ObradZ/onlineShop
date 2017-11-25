<%-- 
    Document   : databaseFail
    Created on : Aug 29, 2017, 9:16:43 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Whoops!</title>
        <link href="style.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <div id="wrapper">
        <div id="header">
        <h1>Something went wrong!(Database)</h1>
        </div>
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
