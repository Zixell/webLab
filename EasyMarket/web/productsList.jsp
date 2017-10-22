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
    int maxInt; %>
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
    <div class="navbar">
        <div href="#" class="navbar-item">
            <a href = "#">SneakShop</a>
            <a href = "#" style = "font-size: 15px;"><%=myres.getString("cart")%></a>
            <a href = "#" style = "font-size: 15px;"><%=myres.getString("history")%></a>
            <a href = "#" style = "font-size: 15px;"><%=myres.getString("signin")%></a>
        </div>
        <div class = "navbar-languages">
            <a href="?lang=ru">ru</a>
            <a href="?lang=en">en</a>
            <a href="?lang=es">es</a>
        </div>
    </div>
<hr>
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
            <%
               /* Cookie[] cookies = request.getCookies();

                if(cookies.length >1) {
                    for (int i = 0; i < cookies.length; i++) {

                        if (cookies[i].getName().equals("min")) {
                            minInt = Integer.parseInt(cookies[i].getValue());
                            System.out.println("cookies");
                        }
                        if (cookies[i].getName().equals("max")) {
                            maxInt = Integer.parseInt(cookies[i].getValue());
                        }
                    }
                } else {
                    if(request.getParameter("min") != null && request.getParameter("max") != null) {
                        String min = request.getParameter("min");
                        String max = request.getParameter("max");
                        minInt = Integer.parseInt(min);
                        maxInt = Integer.parseInt(max);
                    }
                }
                    ArrayList<Product> ls = new ArrayList<Product>();

                    for (Product pr : productsList.getList()) {

                        if (pr.getPrice() >= minInt && pr.getPrice() <= maxInt) {
                            ls.add(pr);
                        }
                    }

                    filtredPage = true;



                       javax.servlet.http.Cookie cookie1 = new Cookie("min", request.getParameter("min"));
                       javax.servlet.http.Cookie cookie2 = new Cookie("max", request.getParameter("max"));
                       response.addCookie(cookie1);
                       response.addCookie(cookie2);

*/

                if(request.getParameter("min") != null && request.getParameter("max") != null) {
                    String min = request.getParameter("min");
                    String max = request.getParameter("max");
                    minInt = Integer.parseInt(min);
                    maxInt = Integer.parseInt(max);
                    ArrayList<Product> ls = new ArrayList<Product>();
                    for (Product pr : productsList.getList()) {
                        if (pr.getPrice() >= minInt && pr.getPrice() <= maxInt) {
                            ls.add(pr);
                        }
                    }
                    filtredPage = true;
                    filtredList.setList(ls);
                } else {
                    filtredPage = false;
                }
                javax.servlet.http.Cookie cookie1 = new Cookie("min", request.getParameter("min"));
                javax.servlet.http.Cookie cookie2 = new Cookie("max", request.getParameter("max"));
                response.addCookie(cookie1);
                response.addCookie(cookie2);



            %>


<div class="filter">
    <%=myres.getString("filter")%>
    <input type="number" size="20" id="min">
    <input type="number" size="20" id="max">
    <input type="submit" id="filter_button" onclick="return AlertValue(this)" value="Accept">
</div>
<div class="field">
<%-- HERE WAS CARD HTML --%>
<%
    if(filtredPage == false) {
%>

<c:forEach var = "item" items = "${productsList.list}">
    <jsp:include page="productCard.jsp">
        <jsp:param name="id" value = "${item.id}"/>
        <jsp:param name="name" value = "${item.name}"/>
        <jsp:param name="price" value="${item.price}"/>
        <jsp:param name="path" value="${item.path}"/>
    </jsp:include>
</c:forEach>
<%
    } else {
%>
    <c:forEach var = "item" items = "${filtredList.list}">
        <jsp:include page="productCard.jsp">
            <jsp:param name="id" value = "${item.id}"/>
            <jsp:param name="name" value = "${item.name}"/>
            <jsp:param name="price" value="${item.price}"/>
            <jsp:param name="path" value="${item.path}"/>
        </jsp:include>
    </c:forEach>

<%}%>
</div>
<hr>

<div class = "footer">
           <table class="w3-table" style="text-decoration: none">
                <tr>
                        <th><%=myres.getString("help")%></th>
                        <th><%=myres.getString("info")%>"</th>
                        <th><%=myres.getString("about")%>"</th>
                </tr>
                <tr>
                        <td><a href = "#"><%=myres.getString("shipping")%></a></td>
                        <td><a href = "#"><%=myres.getString("sizes")%></a></td>
                        <td><a href = "#"><%=myres.getString("us")%></a></td>
                </tr>
                <tr>
                        <td><a href = "#"><%=myres.getString("payment")%></a></td>
                        <td><a href = "#"><%=myres.getString("care")%></a></td>
                        <td><a href = "#"><%=myres.getString("vacancies")%></a></td>
                </tr>
                <tr>
                        <td><a href = "#"><%=myres.getString("ordering")%></a></td>

                        <td><a href = "#"><%=myres.getString("shops")%></a></td>
                </tr>
            </table>
         </div>

</body>
</html>
