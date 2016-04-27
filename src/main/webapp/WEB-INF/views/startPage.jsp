<%--
  Created by IntelliJ IDEA.
  User: roman.golyuk
  Date: 15.04.2016
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>FriendsLeaks</title>
</head>
<body>
<h1>FriendsLeaks</h1>
<ul>
<c:forEach items="${friendsList}" var="friend">
  <li>${friend.name}</li>
</c:forEach>
</ul>
<a href="${pageContext.request.contextPath}/friendsXML">Raw XML</a>
<a href="${pageContext.request.contextPath}/friendsXHTML">XML as HTML</a>
<a href="${pageContext.request.contextPath}/friendsXHTMLServer">XML as HTML (server)</a>
</body>
</html>
