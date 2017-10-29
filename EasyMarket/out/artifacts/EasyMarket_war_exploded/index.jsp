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
<jsp:include page="header.jsp"></jsp:include>
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
