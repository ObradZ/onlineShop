<%-- 
    Document   : login
    Created on : Aug 24, 2017, 5:08:18 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>Login</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>Login</h1>
            </div>
            <%@include file="pageParts/navigation.jsp" %>
            <div id="contentP">
                <h2 class="productsH">Login</h2>
                <form action="Login" name="LogIn" method="post">
                    Username: <input type="text" name="username" ><br><br>
                    Password: <input type="password" name="password"><br><br>
                    <input type="submit" value="Login">
                </form><br>
                
                <p><a href="register.jsp">Dont have account? Click here to sign up!</a></p>
            </div>
           
        </div>
    </body>
</html>
