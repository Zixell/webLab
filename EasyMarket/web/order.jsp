<%@ page import="java.util.ArrayList" %>
<%@ page import="javaClasses.ListOfProducts" %>
<%@ page import="javaClasses.filtredList" %>
<%@ page import="javaClasses.Product" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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

<html>
<head>
        <link rel="stylesheet" href="/style.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
         <script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"/>
    <script src="http://yandex.st/jquery/2.2.3/jquery.min.js" type="text/javascript"></script>
        <title>Order</title>

</head>
<body>
<%//TODO сделать страницу заказа(с картой) и изменить js отвечающий за карту
//TODO локализация страницы заказа
%>
<jsp:include page="header.jsp"/>
        <div class="ordering" style="margin-left: 30%; font-family: 'Courier New', monospace;">
            <h1 class="review_order" style="padding-left: 10%;"><fmt:message key="ordering"/> </h1>
            <div><span class="total_price_msg" style="padding-left: 10%;"><fmt:message key="cartPrice"/> </span>${sessionScope.cartList.cartCost(sessionScope.locale)}<fmt:message key="sign"/> </div>
            <br>
            <div class="" style="padding-left: 10%;">
                <button  class="w3-button by_courier" onclick="delivery_case1()"><fmt:message key="yourself"/> </button>
                <button  class="w3-button by_yourself" onclick="delivery_case2()"><fmt:message key="courier"/></button>
            </div>

            <div id="map_wrapper" class="w3-container city">
                <div id="map" style="width: 550px; height: 400px; margin-right: 10%"></div>
            </div>

            <div id="courier_block_wrapper" class="w3-container city" style="display:none; padding-left: 10%;">
                <p class="courier_text"><fmt:message key="courierText"/><br> </p>
            </div>
            <div class="form_wrapper" style="padding-left: 10%;">
                <form class="order_form" name="orderForm" action="/OrderServlet" method="post">
                    <p><b class="your_name_order"><fmt:message key="yourName"/> </b><br>
                        <input name="customer_name" type="text" size="40">
                    </p>
                    <p><b id="adr"class="your_address_order"><fmt:message key="yourAdress"/></b><br>
                        <input name="customer_address" id="address_form" type="text" size="40">
                    </p>
                    <input id="submit_button" type="submit" value="<fmt:message key="send"/>">
                </form>
            </div>
        </div>
<jsp:include page="footer.jsp"/>
</body>
<script src="secured_js/map.js" type="text/javascript"></script>
<script src="secured_js/order_tabs.js" type="text/javascript"></script>
</html>
