<%--
  Created by IntelliJ IDEA.
  User: Roman Zhuravlev
  Date: 01.10.2017
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class = "product-page">
  <div class="product-item">
    <img src="${param.path}">
    <div class="product-list">
      <h3> ${param.name}</h3>
      <span class="price">₽ ${param.price}</span>
      <a href = "/RofelServlet" for="zayavka" class="button">Подробнее</a>
    </div>
  </div>

</div>

