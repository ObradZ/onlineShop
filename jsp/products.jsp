<%-- 
    Document   : products
    Created on : Aug 17, 2017, 11:13:07 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function tip() {
                var option = document.getElementById("column");
                if (option.value.valueOf() === "Price" || option.value.valueOf() === "Width" || option.value.valueOf() === "Height") {
                    document.getElementById("newValue").type = "number";
                }else if(option.value.valueOf() === "CategoryId"){
                    document.getElementById("newValue").type = "number";
                    document.getElementById("newValue").setAttribute("max","3");
                    document.getElementById("newValue").setAttribute("min","1");
                }else{
                    document.getElementById("newValue").type = "text";
                }
            }

        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>Products</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>Products</h1>
            </div>
            <%@include file="pageParts/userNavigation.jsp" %>

            <div id="contentP">
                <h2 class="productsH">Insert products:</h2>
                <form action="Products" method="post" enctype="multipart/form-data">
                    Category: <br>
                    <select name="category">
                        <option value="1">The Matrix</option>
                        <option value="2">Dota2</option>
                        <option value="3">GoT</option>
                    </select><br><br>
                    Name: <input name="name" type="text"><br><br>
                    Price: <input name="price" type="number">$<br><br>
                    Dimension: <br>
                    Height: <input name="height" type="number">cm<br>
                    Width: <input name="width" type="number">cm<br><br>
                    Image: <input name="image" type="file" accept="image/*"><br><br>
                    Quantity:<select name="stack">
                        <option selected >1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                        <option>10</option>
                    </select><br><br>
                    <input type="submit" value="Insert">
                </form>

                <hr>

                <h3 class="productsH">Delete products:</h3>
                <form method="post" action="ProductsDelete">
                    Select ID <select name="id">
                        <c:forEach items="${figures}" var="figure" >
                            <option>${figure}</option>
                        </c:forEach>
                    </select><br><br>
                    <input type="submit" value="Delete">
                </form>

                <hr>

                <h4 class="productsH">Update products:</h4>
                <form method="post" action="ProductsUpdate">
                    Select ID: 
                    <select name="id">
                        <c:forEach items="${figures}" var="figure" >
                            <option>${figure}</option>
                        </c:forEach>
                    </select><br><br>
                    Select attribute:
                    <select name="column" id="column" onchange="tip()">
                        <option selected>Name</option>
                        <option>Price</option>
                        <option>CategoryId</option>
                        <option>Width</option>
                        <option>Height</option>
                    </select><br><br>
                    Insert new value: 
                    <input type="text" name="newValue" id="newValue"><br><br>
                    <input type="submit" value="Update">
                </form>
                <hr>

            </div>
            <div>

            </div>
        </div>
    </body>
</html>
