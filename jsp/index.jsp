<%-- 
    Document   : index
    Created on : Aug 16, 2017, 12:37:55 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" type="text/css" rel="stylesheet">
        <title>The Matrix</title>
    </head>
    <%
        try {
            if (request.getSession().getAttribute("user").equals("1_true")) {
    %>  
    <body>
        <div id="wrapper">

            <div id="header">
                <h1>Matrix Shop!</h1>
            </div> 

            <%@include file="pageParts/userNavigation.jsp" %>           

            <%@include file="pageParts/userCategories.jsp" %>

            <%@include file="pageParts/content.jsp" %>

        </div>
    </body> 
    <%    } else {
    %>
    <body>
        <div id="wrapper">

            <div id="header">
                <h1>Matrix Shop!</h1>
            </div> 

            <%@include file="pageParts/navigation.jsp" %>           

            <%@include file="pageParts/categories.jsp" %>

            <%@include file="pageParts/content.jsp" %>

        </div>
    </body>     


    <%  }
    } catch (Exception e) {
    %>
    <body>
        <div id="wrapper">

            <div id="header">
                <h1>Matrix Shop!</h1>
            </div> 

            <%@include file="pageParts/navigation.jsp" %>           

            <%@include file="pageParts/categories.jsp" %>

            <%@include file="pageParts/content.jsp" %>

        </div>
    </body>  
    <%
        }
    %>
</html>
