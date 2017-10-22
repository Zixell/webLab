<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: Roman Zhuravlev
  Date: 01.10.2017
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  Locale locale = Locale.ENGLISH;
  String s = request.getParameter("lang");
  if(s != null) {
    if (s.equals("ru")) {
      locale = Locale.forLanguageTag("ru");
    } else if (s.equals("en")) {
      locale = Locale.forLanguageTag("en");
    } else if (s.equals("es")) {
      locale = Locale.forLanguageTag("es");
    }
  } else {
    locale = Locale.ENGLISH;
  }

  ResourceBundle myres = ResourceBundle.getBundle("locale/locales", locale);
%>


<div class = "product-page">
  <div class="product-item">
    <img src="${param.path}">
    <div class="product-list">
      <h3> ${param.name}</h3>
      <span class="price">₽ ${param.price}</span>
      <a href = "/RofelServlet?id=${param.id}" for="zayavka" class="button"><%=myres.getString("more")%></a>
    </div>
  </div>

</div>

