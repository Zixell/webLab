<%--
  Created by IntelliJ IDEA.
  User: Roman Zhuravlev
  Date: 06.11.2017
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>History</title>
</head>
<body id="wrapper">
<jsp:include page="header.jsp"/>
<br>

<jsp:include page="/History"/>
<div id="history_wrapper"><h1 class="Your_history" style="margin-left: 10%"><fmt:message key="yourHistory"/> </h1></div>
<c:choose>
    <c:when test="${empty sessionScope.historyList.list}">
        <div id="empty_case_wrapper"><h1 id="empty_case" class="Your_history_empty" style="margin-left: 40%"><fmt:message key="yourHistoryEmpty"/></h1></div>
    </c:when>
    <c:otherwise>
        <div id="content_wrapper">
                <c:forEach varStatus="curr" var="it" items="${sessionScope.historyList.list}">
                    <div class = "cartItem">
                        <div style="float: left; margin: 10px;"><img src="${it.item.product.getPath()}" width="200" height="200" style=""></div>
                        <div style="float:left; margin: 10px;"><h2>${it.item.product.getName()}</h2><br>${it.consumer}<br>${it.adress}<br>${it.dateTime}</div>

                    </div>
                </c:forEach>
        </div>
    </c:otherwise>
</c:choose>
<jsp:include page="footer.jsp"/>
</body>
</html>