<%--
  Created by IntelliJ IDEA.
  User: abror
  Date: 10/09/22
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CATEGORIES LIST</title>
    <style>
        .status-color {
            color: <c:choose> <c:when test="${status.success}" >green</c:when>
            <c:otherwise>red</c:otherwise></c:choose>
        }
    </style>
</head>
<body>

<h1 class="status-color">${status.message}</h1>
<table border="2" width="70%" cellpadding="2">

<a href="/categories/get-form">+ new category</a>


<c:forEach items="${categories}" var="category" varStatus="loop">
    <tr>
    <td>${category.name}</td>
    <td><a href="/categories/edit/${category.id}">Edit</a></td>
        <td><a href="/categories/delete/${category.id}">Delete</a></td>
    </tr>
</c:forEach>


</body>
</html>
