<%--
  Created by IntelliJ IDEA.
  User: cenkc
  Date: 3/15/2019
  Time: 5:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${owners}" var="o">
    ${o.id} ${o.firstName} ${o.lastName}<br/>
</c:forEach>
</body>
</html>
