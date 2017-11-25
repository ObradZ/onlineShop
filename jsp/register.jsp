<%-- 
    Document   : register
    Created on : Aug 23, 2017, 6:18:09 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>Register</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>Welcome,please register!</h1>
            </div>
            <%@include file="pageParts/navigation.jsp" %>
            <div id="contentP">
                <h2 class="productsH">Register</h2>
                <form action="register" name="Register" method="post">
                    Username: <input name="username" type="text"><br><br>
                    Password: <input name="password" type="password"><br><br>
                    <input type="submit" value="Register">
                </form>
            </div>
        </div>
    </body>
</html>
