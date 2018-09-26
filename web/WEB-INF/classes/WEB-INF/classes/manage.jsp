<%--
  Created by IntelliJ IDEA.
  User: 14455
  Date: 2018/9/19
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <title>管理界面</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/search.udo" method="post">
        <div>
            <div class="form-group">
                <label style="margin-left: 10px">Username:</label>
                <input type="text" class="form-control" style="width: 200px; margin-left: 10px;" name="username"/>
            </div>
            <div class="form-group">
                <label style="margin-left: 10px">Address</label>
                <input type="text" class="form-control" style="width: 200px; margin-left: 10px" name="address"/>
            </div>
            <div class="form-group">
                <label style="margin-left: 10px">Phone</label>
                <input type="text" class="form-control" style="width: 200px; margin-left: 10px" name="phone"/>
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
            <a href="<%=request.getContextPath()%>/add.jsp" class="btn btn-success">Add User</a>
            <a href="<%=request.getContextPath()%>/logout.udo" class="btn btn-warning">Log out</a>
        </div>
</form>
        <table class="table table-borderless table-hover table-sm">
            <thead class="thead-dark">
            <tr>
                <th>id</th>
                <th>用户名</th>
                <th>地址</th>
                <th>电话</th>
                <th>简介</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty users}">
                <c:forEach var="user" items="${users}">
                    <tr class="table-light">
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.address}</td>
                        <td>${user.phone}</td>
                        <td>${user.info}</td>
                        <td><a href="<%=request.getContextPath()%>/update.udo?id=${user.id}">修改</a> <a href="<%=request.getContextPath()%>/delete.udo?id=${user.id}">删除</a></td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
</body>
</html>
