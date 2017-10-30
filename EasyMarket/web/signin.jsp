<%--
  Created by IntelliJ IDEA.
  User: Roman Zhuravlev
  Date: 29.10.2017
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="j_security_check" method="post" name="loginForm">
    <input type="text" name="j_username" placeholder="имя"
           size="20"/><br>
    <label>GOVNO</label><br>
    <input type="password" name="j_password" size="20"/><br>
    <input type="submit" value="Ввод"/>
</form>
<a href="productsList.jsp">TO LIST</a>

</body>
</html>
