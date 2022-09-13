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
    <title>EDIT USER</title>
</head>
<body>

<form action="/users/edit" method="post">
    <input type="text" name="id" hidden value="${user.id}">
    <label for="full_name">full_name </label>
    <input value="${user.full_name}" name="full_name" type="text" id="full_name">
    <hr>
    <label for="phone_number">phone_number </label>
    <input value="${user.phone_number}" name="phone_number" type="text" id="phone_number">
    <hr>
    <label for="is_admin">is_admin </label>
    <input value="${user.admin}" name="is_admin" type="text" id="is_admin">
    <hr>
    <label for="password">password </label>
    <input value="${user.password}" name="password" type="text" id="password">
    <hr>
    <button type="submit">Saqlash</button>
</form>

</body>
</html>
