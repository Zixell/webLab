<%--
  Created by IntelliJ IDEA.
  User: Roman Zhuravlev
  Date: 01.10.2017
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <meta charset="utf-8">
  <title></title>
  <link rel = "stylesheet" href = "style.css">

</head>

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

<a href = "http://localhost:8080/productsList.jsp">GO LIST</a>

<script src="javascript.js"></script>
<script>
    var myTabs = tabs({
        el: '#tabs',
        tabNavigationLinks: '.c-tabs-nav__link',
        tabContentContainers: '.c-tab'
    });

    myTabs.init();
</script>
