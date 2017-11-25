<%-- 
    Document   : homepage
    Created on : Aug 23, 2017, 10:47:17 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Matrix</title>
        <link href="style.css" type="text/css" rel="stylesheet">
    </head>

    <!--Checking if there is a session, and is it having the right attribute -->
    <%
        try {
            if (request.getSession().getAttribute("user").equals("1_true")) {
    %>   

    <!--Everything is good , here is your page! -->

    <body>
        <div id="wrapper">
            <div id="header">
                <h1 id="h1">Hello ${cookie['name'].value}</h1>
            </div>
            <%@include file="pageParts/userNavigation.jsp" %>
            <%@include file="pageParts/userCategories.jsp" %>
            <div id="content"> 
                <c:forEach items="${figures}" var="figure">
                    <span>
                        <p>${figure.name}: ${figure.price}$</p>
                        <a href="Buy1?ide=${figure.id}"><img src="${figure.image}" alt="OVA"></a>
                        <p>ID:${figure.id}<br>Width:${figure.width} Height:${figure.height}<br>
                            Stack: ${figure.stack}
                        </p>

                    </span>
                </c:forEach>
            </div> 


        </div>
    </body>

    <!--Not good, link to Index for login form! -->        
    <%    } else {
                response.sendRedirect("Index");

            }
        } catch (Exception e) {
            response.sendRedirect("Index");
        }
    %>

</html>
