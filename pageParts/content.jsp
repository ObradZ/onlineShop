<div id="content"> 
   
    <c:forEach items="${figures}" var="figure">
         <span>
        <p>${figure.name}: ${figure.price}$</p>
        <a href="login.jsp"><img src="${figure.image}" alt="OVA"></a>
        <p>ID:${figure.id}<br>Width:${figure.width} Height:${figure.height}<br>
            Stack: ${figure.stack}
        </p>
        </span>
        
    </c:forEach>
</div>
