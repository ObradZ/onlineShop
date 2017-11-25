<%-- 
    Document   : status
    Created on : Aug 30, 2017, 9:21:04 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" type="text/css" rel="stylesheet">
        <title>Status</title>
    </head>
    <body>
        <div id="wrapper">

            <div id="header">
                <h1>Matrix Shop!</h1>
            </div> 

            <%@include file="pageParts/userNavigation.jsp" %>           
            <div id="contentP">
                <h2 class="productsH">Username: ${user.name}</h2>  
                <h3 class="productsH">Money: ${user.money}$</h3>
            </div>

        </div>
    </body>
</html>
