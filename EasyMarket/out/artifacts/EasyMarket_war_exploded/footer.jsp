<%@ page import="java.util.ArrayList" %>
<%@ page import="javaClasses.ListOfProducts" %>
<%@ page import="javaClasses.filtredList" %>
<%@ page import="javaClasses.Product" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>

<%--
  Created by IntelliJ IDEA.
  User: Roman Zhuravlev
  Date: 17.10.2017
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
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

<div class = "footer">
    <table class="w3-table" style="text-decoration: none">
        <tr>
            <th><fmt:message key="help"/> </th>
            <th><fmt:message key="info"/>"</th>
            <th><fmt:message key="about"/>"</th>
        </tr>
        <tr>
            <td><a href = "#"><fmt:message key="shipping"/></a></td>
            <td><a href = "#"><fmt:message key="sizes"/></a></td>
            <td><a href = "#"><fmt:message key="us"/></a></td>
        </tr>
        <tr>
            <td><a href = "#"><fmt:message key="payment"/></a></td>
            <td><a href = "#"><fmt:message key="care"/></a></td>
            <td><a href = "#"><fmt:message key="vacancies"/></a></td>
        </tr>
        <tr>
            <td><a href = "#"><fmt:message key="ordering"/></a></td>

            <td><a href = "#"><fmt:message key="shops"/></a></td>
        </tr>
    </table>
</div>
</body>
</html>
