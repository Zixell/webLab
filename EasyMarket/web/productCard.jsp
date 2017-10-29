<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: Roman Zhuravlev
  Date: 01.10.2017
  Time: 19:55
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

<div class = "product-page">
  <div class="product-item">
    <img src="${param.path}">
    <div class="product-list">
      <h3> ${param.name}</h3>
      <span class="price"><fmt:message key="sign"/>
        <%--<c:if test="${sessionScope.locale eq 'es'}">--%>
          <%--${param.price div 67}--%>
        <%--</c:if>--%>
        <%--<c:if test="${sessionScope.locale eq 'ru'}">--%>
          <%--${param.price}--%>
        <%--</c:if>--%>
        <%--<c:if test="${empty sessionScope.locale or sessionScope.locale eq 'en'}">--%>
          <%--${param.price div 58}--%>
        <%--</c:if>--%>
        ${param.price}

      </span>
      <a href = "/RofelServlet?id=${param.id}&lang=<%=session.getAttribute("locale")%>" for="zayavka" class="button"><fmt:message key="more"/> </a>
    </div>
  </div>

</div>

