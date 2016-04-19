<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Facebook friends</title>
</head>
<body>
<div id="content">
  <h3>Your Facebook Friends</h3>

  <ul class="friends">
    <c:forEach items="${friendsList}" var="friend">
      <li "friend : ${friends}"><img th:src="'http://graph.facebook.com/' + ${friend.id} + '/picture'" align="middle"/><span th:text="${friend.name}">name</span></li>
        <option value="${restype.typeName}">${restype.typeName}</option>
    </c:forEach>
    <li th:each="friend : ${friends}"><img th:src="'http://graph.facebook.com/' + ${friend.id} + '/picture'" align="middle"/><span th:text="${friend.name}">name</span></li>
  </ul>
</div>
</body>
</html>
