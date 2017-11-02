<%@ page import="java.util.ArrayList" %>
<%@ page import="javaClasses.ListOfProducts" %>
<%@ page import="javaClasses.filtredList" %>
<%@ page import="javaClasses.Product" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="/style.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<script>

    if(window.location != 'http://localhost:8080/cart.jsp'){
        window.location = 'cart.jsp';
    }
</script>
<c:if test="${empty sessionScope.locale}">
    <fmt:setLocale value="en"/>
</c:if>
<c:if test="${sessionScope.locale eq 'ru'}">
    <fmt:setLocale value="ru"/>
</c:if>
<c:if test="${sessionScope.locale eq 'en'}">
    <fmt:setLocale value="en"/>
</c:if>
<c:if test="${sessionScope.locale eq 'es'}">
    <fmt:setLocale value="es"/>
</c:if>
<fmt:setBundle basename="locale/locales"/>


<jsp:include page="header.jsp"></jsp:include>


<c:choose>
    <c:when test="${empty sessionScope.cartList.list}">
        <div id="empty_case_wrapper"><h1 id="empty_case" style="margin-left: 40%;">
            <fmt:message key="empty"></fmt:message>
        </h1></div>
    </c:when>
    <c:otherwise>
        <c:forEach varStatus="curr" var="item" items="${sessionScope.cartList.list}">
            <%--<script>--%>
                <%--var q = ${item.count};--%>
                <%--if(q == '0'){--%>
                    <%--window.location='/cartList?add=delete&id='+uid;--%>
                <%--}--%>
            <%--</script>--%>
            <div class = "cartItem">
                <script> uid = ${item.product.getId()};</script>
                <div style="float: left; margin: 10px;"><img src="${item.product.getPath()}" width="200" height="200" style=""></div>
                <div style="float:left; margin: 10px;"><h2>${item.product.getName()}</h2><br>${item.product.getShortDes(sessionScope.locale)}</div>
                <div style="float: right;"><a href="/cartList?add=delete&id=${item.product.getId()}" style="text-decoration: none; font-size: 20px;">X</a></div>
                <div style="float:right; margin: 10px; padding: 100px;">
                    <fmt:message key="sign"/>${item.getPrice(sessionScope.locale)}
                    <a href="/cartList?add=0&id=${item.product.getId()}" onclick="">-</a>
                        ${item.count}
                    <a href="/cartList?add=1&id=${item.product.getId()}" onclick="">+</a>

                </div>


            </div>
        </c:forEach>
        <div class="order">
            <div class="cartCost"><fmt:message key="cartPrice"></fmt:message><fmt:message key="sign"/>${sessionScope.cartList.cartCost(sessionScope.locale)}</div>
            <div class="order_button" style="">
                <a href="order.jsp">ORDER</a>
            </div>
        </div>

    </c:otherwise>
    </c:choose>

<br>
<jsp:include page="footer.jsp"/>
</body>
</html>
