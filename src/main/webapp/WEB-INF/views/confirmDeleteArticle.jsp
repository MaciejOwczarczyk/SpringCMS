<%--
  Created by IntelliJ IDEA.
  User: maciejowczarczyk
  Date: 03/10/2019
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <table class="table">
        <tr>
            <th>Action</th>
        </tr>
        <tr>
            <td>
                <a href="/article/showAll" class="btn btn-primary">Cancel</a>
                <a href="/article/delete/${articleId}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
