<%--
  Created by IntelliJ IDEA.
  User: maciejowczarczyk
  Date: 03/10/2019
  Time: 22:20
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
    <form:form method="post" modelAttribute="article">
        <label>Title:</label>
        <form:input path="title" id="titleId" type="text" class="form-control"/>

        <br/>

        <label>Content:</label>
        <form:textarea path="content" cols="5" rows="5" class="form-control" id="contentId"/>

        <br/>

        <label for="authorId">Author</label>
        <form:select path="author.id" items="${authors}" itemLabel="fullName" itemValue="id" id="authorId" class="form-control"/>

        <label for="categoriesId">Categories</label>
        <form:select path="categories" items="${categories}" itemLabel="name" itemValue="id" id="categoriesId" class="form-control"/>

        <br/>

        <input type="submit" class="btn btn-primary" value="Save">

    </form:form>
</div>
</body>
</html>
