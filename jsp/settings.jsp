<%-- 
    Document   : settings
    Created on : Aug 30, 2017, 1:38:03 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Settings</title>
        <link href="style.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <div id="wrapper">
        <div id="header">
        <h1>Settings</h1>
        </div>
        <%@include file="pageParts/userNavigation.jsp" %>
        <div id="contentP">
             <h2 class="productsH">Set money</h2>
                <form action="addMoney"  method="post">
                    Set money: <input type="number" name="money" min="0">$<br><br>
                    <input type="submit" value="I am rich!">
                </form><br>
            <h3 class="productsH">Change password</h3>
            <form action="ChangePassword"  method="post">
                    Old password: <input type="password" name="oldPassword" ><br><br>
                    New password: <input type="password" name="newPassword"><br><br>
                    <input type="submit" value="Change">
                </form><br>
                <h4 class="productsH">Delete account</h4>
                <form action="DeleteAcc"  method="post">
                    Password: <input type="password" name="password"><br><br>
                    <input type="submit" value="Delete" color="red">
                </form><br>
        </div>
            </div>
    </body>
</html>
