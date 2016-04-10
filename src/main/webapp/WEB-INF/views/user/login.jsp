<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/social-buttons-3.css"/>
</head>
<body>
<div class="page-header">
    <h1>Facebook likes</h1>
</div>
<sec:authorize access="isAnonymous()">
    <!-- Login form -->
    <div class="panel panel-default">

    <!-- Social Sign In Buttons -->
    <div class="panel panel-default">
        <div class="panel-body">
            <h2>Log in with Facebook</h2>
            <div class="row social-button-row">
                <div class="col-lg-4">
                    <!-- Add Facebook sign in button -->
                    <a href="${pageContext.request.contextPath}/auth/facebook"><button class="btn btn-facebook"><i class="icon-facebook"></i> | Facebook</button></a>
                </div>
            </div>
        </div>
    </div>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <p>Authenticated successfully</p>
</sec:authorize>
</body>
</html>