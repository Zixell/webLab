<%@ page import="java.util.ArrayList" %>
<%@ page import="javaClasses.ListOfProducts" %>
<%@ page import="javaClasses.filtredList" %>
<%@ page import="javaClasses.Product" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="javaClasses.*" %>

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
<html>
<head>

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

<div class="navbar">
    <div href="#" class="navbar-item">
        <a href = "productsList.jsp">SneakShop</a>
        <a href = "cart.jsp" style = "font-size: 15px;"><fmt:message key="cart"/>
            <c:choose>
                <c:when test="${empty sessionScope.cartList.list}">
                    (0)
                </c:when>
                <c:otherwise>
                    (${sessionScope.cartList.list.size()})
                </c:otherwise>
            </c:choose>
        </a>
        <a href = "history.jsp" style = "font-size: 15px;"><fmt:message key="history"/></a>
        <%
            if(request.isUserInRole("tomcat")){
                if(session.getAttribute("cartList") != null){
        %>
        <a href="/order.jsp" style = "font-size: 15px;"><fmt:message key="ordering"/>(${sessionScope.cartList.list.size()})</a>
        <%}%>
        <a href="/profile.jsp" style = "font-size: 15px;"><%=request.getUserPrincipal().getName()%></a>
        <a href="/logout" style = "font-size: 15px;"><fmt:message key="logout"/> </a>
        <%}else {%>
        <a href = "/MyProfile" style = "font-size: 15px;"><fmt:message key="signin"/></a>
        <%}
        %>
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
