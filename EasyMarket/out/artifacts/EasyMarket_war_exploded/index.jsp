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

<div class="product-item">
  <img src="gta5card.png">
  <div class="product-list">
    <h3>Grand theft auto V</h3>
    <span class="price">₽ 1999</span>
    <a href = "/RofelServlet" for="zayavka" class="button">Подробнее</a>
  </div>
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
