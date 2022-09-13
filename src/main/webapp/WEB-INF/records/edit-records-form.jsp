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
    <title>EDIT RECORDS</title>
</head>
<body>

<form action="/records/edit" method="post">
    <input type="text" name="id" hidden value="${records.id}">
    <label for="is_returned">is_returned </label>
    <input value="${records.is_returned}" name="is_returned" type="text" id="is_returned">
    <hr>
    <label for="dateTime">dateTime </label>
    <input value="${records.dateTime}" name="dateTime" type="text" id="dateTime">
    <hr>
    <label for="user_id">user_id </label>
    <input value="${records.admin}" name="user_id" type="text" id="user_id">

    <button type="submit">Saqlash</button>
</form>

</body>
</html>
