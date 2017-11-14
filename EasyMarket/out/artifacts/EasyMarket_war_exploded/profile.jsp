<%@ page import="java.util.ArrayList" %>
<%@ page import="javaClasses.ListOfProducts" %>
<%@ page import="javaClasses.filtredList" %>
<%@ page import="javaClasses.Product" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="/style.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Profile</title>
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
<jsp:include page="header.jsp"/>
<div class="profile_body" style="margin-left: 10%">
<h1 class=" text_1"><span class="invite_msg"><fmt:message key="hello"/>,</span> ${pageContext.request.userPrincipal.name}!</h1>

<div>
    <fmt:message key="init"/>:
</div>
<c:if test="${empty sessionScope.init}">
    undefined
</c:if>
<c:if test="${sessionScope.init eq '0'}">
    1
</c:if>
<c:if test="${sessionScope.init eq '1'}">
    2
</c:if>
<c:if test="${sessionScope.init eq '2'}">
    3
</c:if>
<br>
<br>
<span class="curr_time"><fmt:message key="currTime"/></span>

<div id="ctm"> </div>
<br>
</div>
<div class="comment_area_wrapper" style="margin-left: 10%">
    <h1 class="text_1"><span class="leave_comment_line"><fmt:message key="leaveYourComments"/></span></h1>
    <textarea wrap="off" cols="30" rows="5" id="comment_text_area">

    </textarea>
    <br>
    <a class="click_comment" onclick="ajaxPOST('&all=1')"><fmt:message key="send"/></a>
</div>

<div id="comments_wrapper" class="w3-container city" style="margin-left: 5%">
    <div id="latest_comments_wrapper">
        <p class="text_1 "><span class="last_comments"><fmt:message key="lastComments"/></span></p><br>
        <div id="latest_comments_insert"></div>
    </div>
    <div id="basic_info_wrapper" class="w3-container city" style="display:none">
        stf
    </div>
</div>

<jsp:include page="footer.jsp"/>

<script src="secured_js/ajax_comments.js" type="text/javascript"></script>
<script src="secured_js/ajax_time.js" type="text/javascript"></script>



<%--<c:choose>--%>
    <%--<c:when test="${empty sessionScope.commentsList.list}">--%>
        <%--<div id="empty_case_wrapper"><h1 id="empty_case" class="Your_history_empty" style="margin-left: 40%"><fmt:message key="yourHistoryEmpty"/></h1></div>--%>
    <%--</c:when>--%>
    <%--<c:otherwise>--%>
        <%--<div id="content_wrapper">--%>
            <%--<c:forEach varStatus="curr" var="it" items="">--%>
                <%--<div class = "">--%>
                    <%--<div style="">${it.comment}</div>--%>
                    <%--<div style="">${it.dateTime}</div>--%>

                <%--</div>--%>
            <%--</c:forEach>--%>
        <%--</div>--%>
    <%--</c:otherwise>--%>
<%--</c:choose>--%>


</body>
</html>
