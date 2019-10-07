<%--
  Created by IntelliJ IDEA.
  User: maciejowczarczyk
  Date: 04/10/2019
  Time: 00:08
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
            <th>To this author some articles have been assigned, you cannot delete it</th>
        </tr>
        <tr>
            <td>
                <a href="/category/showAll" class="btn btn-success">Cancel</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
