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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <table class="table">
        <tr>
            <th>
                <a href="/article/add" class="btn btn-success">Add new article</a>
            </th>
        </tr>
        <tr>
            <th>Title</th>
            <th>Content</th>
            <th>Author</th>
            <th>Categories</th>
            <th>Created on</th>
        </tr>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td>${article.title}</td>
                <td>${article.content.substring(0, 10)}...</td>
                <td>${article.author.fullName}</td>
                <td>
                    <c:forEach items="${article.categories}" var="category">
                        ${category.name}<br>
                    </c:forEach>
                </td>
                <td>${article.createdOn}</td>
                <td>
                    <a href="/article/edit/${article.id}" class="btn btn-primary">Edit</a>
                    <a href="/article/confirmDelete/${article.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <th>
                <a href="/" class="btn btn-warning">Back</a>
            </th>
        </tr>
    </table>
</div>
</body>
</html>
