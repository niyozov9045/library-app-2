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
    <title>ADD CATEGORY</title>
</head>
<body>

<form action="/categories" method="post">
    <label for="name">name </label>
    <input name="name" type="text" id="name">
    <hr>
    <label for="description">description </label>
    <input description="description" type="text" id="description">
    <hr>

    <hr>
    <button type="submit">Saqlash</button>
</form>

</body>
</html>
