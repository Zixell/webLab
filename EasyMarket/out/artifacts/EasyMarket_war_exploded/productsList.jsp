<%@ page import="java.util.ArrayList" %>
<%@ page import="javaClasses.ListOfProducts" %>
<%@ page import="javaClasses.Product" %>

<%--
  Created by IntelliJ IDEA.
  User: Roman Zhuravlev
  Date: 17.10.2017
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <jsp:useBean id="productsList" class="javaClasses.ListOfProducts" scope="session"/>
    <link rel="stylesheet" href="/style.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>SneakShop</title>
</head>

<body>
    <div class="navbar">
        <div href="#" class="navbar-item">
            <a href = "#">SneakShop</a>
            <a href = "#" style = "font-size: 15px;">Cart</a>
            <a href = "#" style = "font-size: 15px;">History</a>
            <a href = "#" style = "font-size: 15px;">Sigh in</a>
        </div>
        <div class = "navbar-languages">
            <a href="?lang=ru">ru</a>
            <a href="?lang=en">en</a>
            <a href="?lang=es">es</a>
        </div>
    </div>
<hr>

<%-- HERE WAS CARD HTML --%>

<c:forEach var = "item" items = "${productsList.list}">
    <jsp:include page="productCard.jsp">
        <jsp:param name="name" value = "${item.name}"/>
        <jsp:param name="price" value="${item.price}"/>
        <jsp:param name="path" value="${item.path}"/>
    </jsp:include>
</c:forEach>

<hr>
<div class = "footer">
    <table class="w3-table tab" style="text-decoration: none">
        <tr>
            <th>Помощь</th>
            <th>Информация</th>
            <th>О компании</th>
        </tr>
        <tr>
            <td><a href = "#">Доставка</a></td>
            <td><a href = "#">Таблицы размеров</a></td>
            <td><a href = "#">О нас</a></td>
        </tr>
        <tr>
            <td><a href = "#">Оплата</a></td>
            <td><a href = "#">Уход за товаром</a></td>
            <td><a href = "#">Вакансии</a></td>
        </tr>
        <tr>
            <td><a href = "#">Оформление заказа</a></td>

            <td><a href = "#">Магазины</a></td>
        </tr>
    </table>
</div>

<script src="javascript.js"></script>
<script>
    var myTabs = tabs({
        el: '#tabs',
        tabNavigationLinks: '.c-tabs-nav__link',
        tabContentContainers: '.c-tab'
    });

    myTabs.init();
</script>
</body>
</html>
