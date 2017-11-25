<%-- 
    Document   : buy
    Created on : Aug 29, 2017, 10:56:19 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>Buy</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>Matrix shop!</h1>
            </div> 

            <%@include file="pageParts/userNavigation.jsp" %>     
            <%@include file="pageParts/userCategories.jsp" %>

            <div id="contentP">
                <h2 class="productsH">${af.name}: ${af.price}$</h2>
                <img src="${af.image}" alt="OVA" id="buy">
                <p>ID:${af.id}<br>Width:${figure.width} Height:${af.height}<br>
                    Stack: ${af.stack}
                </p>
                <form action="Buy2" method="post">
                    Quantity: <input type="number" id="quantity" oninput="cena()" name="stack" max="${af.stack}" min="1"><br><br>
                    Price: <input type="text" disabled id="cost" name="cost">
                    <input type="hidden" value="${af.id}" name="id">
                    <input type="hidden" value="${af.price}" name="price">
                    <input type="submit" value="Buy">
                </form>
            </div>

        </div>
    </body>
    <script>
        var b = document.getElementById("contentP").offsetHeight;
        document.getElementById("categories").setAttribute("style", "height:" + b + "px");
    </script>
    <script>
        function cena() {
            var price =${af.price};
            var quantity = document.getElementById("quantity").value;
            var cost = price * quantity;
            var text = cost + "$";
            document.getElementById("cost").value = text;
        }
    </script>

</html>
