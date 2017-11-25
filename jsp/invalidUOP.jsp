<%-- 
    Document   : invalidUOP
    Created on : Aug 30, 2017, 1:31:33 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invalid insert</title>
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="wrapper">
        <div id="header">
        <h1>Invalid username or password!</h1>
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
