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


<html>
<head>
    <jsp:useBean id="productsList" class="javaClasses.ListOfProducts" scope="session"/>
    <jsp:useBean id="filtredList" class="javaClasses.filtredList" scope="session"/>
    <link rel="stylesheet" href="/style.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>SneakShop</title>
</head>

<body>

<%! int minInt;
    int maxInt;
     Cookie cookieMin = null;
     Cookie cookieMax = null;
    boolean cancel = false;%>
<%




%>
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


<jsp:include page="header.jsp"/>

    <%! boolean filtredPage = false; %>
    <script>
        function AlertValue(Element) {
            var minIn = document.getElementById('min').value;
            var maxIn = document.getElementById('max').value;
            if(minIn != "" && minIn != null && maxIn != "" && maxIn != null) {
                window.location = 'productsList.jsp?min=' + minIn + '&max=' + maxIn;
            } else {
                window.location = 'productsList.jsp';
            }
        }
    </script>




<div class="filter">
    <fmt:message key="filter"/>
    <input type="number" size="10" id="min">
    <input type="number" size="10" id="max">
    <input type="submit" id="filter_button" class="filter_button" onclick="return AlertValue(this)" value="<fmt:message key="accept"/>">
    <input type="submit" id="nofilter" class="nofilter" onclick="cancelFilter(this)" value="X">
</div>
<div class="field">
<%-- HERE WAS CARD HTML --%>
    <script>
        function cancelFilter() {
            if(document.getElementById("nofilter").onclick){
                window.location = 'productsList.jsp?filter=cancel';
            }

        }
    </script>

    <%

        if(request.getParameter("min") !=  null && request.getParameter("max") != null) {
            String min = request.getParameter("min");
            String max = request.getParameter("max");
            minInt = Integer.parseInt(min);
            maxInt = Integer.parseInt(max);
            javax.servlet.http.Cookie cookie1 = new Cookie("min", min);
            response.addCookie(cookie1);
            javax.servlet.http.Cookie cookie2 = new Cookie("max", max);
            response.addCookie(cookie2);
        } else {
                Cookie[] cookies = request.getCookies();
                System.out.println(cookies);
                if(cookies != null) {
                    for (Cookie cookie :
                            cookies) {
                        if ("min".equals(cookie.getName())) {
                            cookieMin = cookie;
                            if(cookie.getValue() != "") minInt = Integer.parseInt(cookieMin.getValue());

                        } else {

                        }
                        if ("max".equals(cookie.getName())) {
                            cookieMax = cookie;
                            if(cookie.getValue() != "") maxInt = Integer.parseInt(cookieMax.getValue());
                        } else{

                        }
                    }


                } else {
                    javax.servlet.http.Cookie cookie1 = new Cookie("min", "0");
                    response.addCookie(cookie1);
                    javax.servlet.http.Cookie cookie2 = new Cookie("max", "9999999");
                    response.addCookie(cookie2);

                }

            }

        ArrayList<Product> ls = new ArrayList<Product>();
        for (Product pr : productsList.getList()) {
            if (pr.getPrice((String) session.getAttribute("locale")) >= minInt && pr.getPrice((String) session.getAttribute("locale")) <= maxInt) {
                ls.add(pr);
            }
        }

        filtredList.setList(ls);
        if(request.getParameter("filter") != null) {
            filtredList.setList(null);
        }
        if(filtredList.getList() != null){
    %>
    <c:forEach var = "item" items = "${filtredList.list}">
        <jsp:include page="productCard.jsp">
            <jsp:param name="id" value = "${item.id}"/>
            <jsp:param name="name" value = "${item.name}"/>
            <jsp:param name="price" value="${item.getPrice(sessionScope.locale)}"/>
            <jsp:param name="path" value="${item.path}"/>
        </jsp:include>
    </c:forEach>
    <div class="filter_info"><fmt:message key="filter"/>: <fmt:message key="from"/> <%=minInt%> <fmt:message key="to"/> <%=maxInt%></div>

    <%
    } else {%>
    <c:forEach var = "item" items = "${productsList.list}">
        <jsp:include page="productCard.jsp">
            <jsp:param name="id" value = "${item.id}"/>
            <jsp:param name="name" value = "${item.name}"/>
            <jsp:param name="price" value="${item.getPrice(sessionScope.locale)}"/>
            <jsp:param name="path" value="${item.path}"/>
        </jsp:include>
    </c:forEach>
    <%

        }

    %>

</div>
<hr>

<jsp:include page="footer.jsp"/>

</body>
</html>
