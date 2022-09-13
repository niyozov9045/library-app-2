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
    <title>ADD RECORDS</title>
</head>
<body>

<form action="/records" method="post">
<%--    <label for="is_returned">is_returned </label>--%>
<%--    <input name="is_returned" type="text" id="is_returned">--%>
<%--    <hr>--%>
<%--    <label for="dateTime">dateTime </label>--%>
<%--    <input name="dateTime" type="text" id="dateTime">--%>
<%--    <hr>--%>
    <label for="user_id">user_id </label>
    <input name="user_id" type="text" id="user_id">
    <button type="submit">Saqlash</button>
</form>

</body>
</html>
