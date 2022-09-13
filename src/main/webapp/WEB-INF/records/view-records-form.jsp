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
    <title>RECORDS LIST</title>
</head>
<body>
<table border="2" width="70%" cellpadding="2">

<a href="/records/get-form">+ new records</a>


<c:forEach items="${recordList}" var="record" varStatus="loop">
    <tr>>
    <td>${record.is_returned}</td>
    <td><a href="/records/edit/${record.id}">Edit</a></td>
    <td><a href="/records/delete/${record.id}">Delete</a></td>
    </tr

</c:forEach>

</table>

</body>
</html>
