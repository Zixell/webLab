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

</head>
<body>
<%--<%--%>
<%--Locale locale = Locale.ENGLISH;--%>
<%--String s = request.getParameter("lang");--%>
<%--if(s != null) {--%>
<%--if (s.equals("ru")) {--%>
<%--locale = Locale.forLanguageTag("ru");--%>
<%--} else if (s.equals("en")) {--%>
<%--locale = Locale.forLanguageTag("en");--%>
<%--} else if (s.equals("es")) {--%>
<%--locale = Locale.forLanguageTag("es");--%>
<%--}--%>
<%--} else {--%>
<%--locale = Locale.ENGLISH;--%>
<%--}--%>

<%--ResourceBundle myres = ResourceBundle.getBundle("locale/locales", locale);--%>


<%--%>--%>
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

<div class="navbar">
    <div href="#" class="navbar-item">
        <a href = "productsList.jsp">SneakShop</a>
        <a href = "cart.jsp" style = "font-size: 15px;"><fmt:message key="cart"/></a>
        <a href = "#" style = "font-size: 15px;"><fmt:message key="history"/></a>
        <a href = "#" style = "font-size: 15px;"><fmt:message key="signin"/></a>
    </div>
    <div class = "navbar-languages">
        <a href="/changerLocale?lang=ru&re=${pageContext.request.requestURL}">ru</a>
        <a href="/changerLocale?lang=en&re=${pageContext.request.requestURL}">en</a>
        <a href="/changerLocale?lang=es&re=${pageContext.request.requestURL}">es</a>
    </div>
</div>


<hr>
</body>
</html>
