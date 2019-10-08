<%--
  Created by IntelliJ IDEA.
  User: maciejowczarczyk
  Date: 03/10/2019
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <h1 class="label">Drafts</h1>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <table class="table">
        <tr>
            <th>
                <a href="/draft/add" class="btn btn-success">Add new article/draft</a>
            </th>
        </tr>
        <tr>
            <th>Title</th>
            <th>Content</th>
        </tr>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td>${article.title}</td>
                <td>${article.content.substring(0, 10)}...</td>
                <td>
                    <a href="/draft/edit/${article.id}" class="btn btn-primary">Edit</a>
                    <a href="/draft/confirmDelete/${article.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <th>
                <a href="/article/showAll" class="btn btn-warning">Back</a>
            </th>
        </tr>
    </table>
</div>
</body>
</html>
