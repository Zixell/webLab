<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Roman Zhuravlev
  Date: 29.10.2017
  Time: 20:12
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
    <title>Sign in</title>
    <link rel="stylesheet" href="/style.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="signin_form">
    <form action="j_security_check" method="post" name="loginForm">
        <label style="font-family: 'Courier New', monospace;"><fmt:message key="login"/></label><br>
        <input type="text" name="j_username" placeholder="login" size="20"/><br>
        <label style="font-family: 'Courier New', monospace;"><fmt:message key="password"/></label><br>
        <input type="password" name="j_password" size="20"/><br>
        <input type="submit" value="<fmt:message key="send"/>"/>
    </form>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>
