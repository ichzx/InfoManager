<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 14455
  Date: 2018/9/20
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <title>添加用户</title>
</head>
<body>
<c:if test="${not empty requestScope.message}">
    <center>
        <span style="color: red">${message}</span>
    </center>
</c:if>
<form action="<%=request.getContextPath()%>/add.udo" method="post">
    <div class="form-group">
        <label style="margin-left: 10px">Username:</label>
        <input type="text" class="form-control" style="width: 200px; margin-left: 10px" name="username"/>
    </div>
    <div class="form-group">
        <label style="margin-left: 10px">Password:</label>
        <input type="password" class="form-control" style="width: 200px; margin-left: 10px" name="password"/>
    </div>
    <div class="form-group">
        <label style="margin-left: 10px">Phone</label>
        <input type="text" class="form-control" style="width: 200px; margin-left: 10px" name="phone"/>
    </div>
    <div class="form-group">
        <label style="margin-left: 10px">Address</label>
        <input type="text" class="form-control" style="width: 200px; margin-left: 10px" name="address"/>
    </div>
    <div class="form-group">
        <label style="margin-left: 10px">Info</label>
        <input type="text" class="form-control" style="width: 250px; margin-left: 10px" name="info"/>
    </div>
    <button type="submit" class="btn btn-primary" style="margin-left: 10px">Add</button>
    <%--<center>--%>
        <%--<table border="" style="margin-top: 50px; padding: 30px">--%>
            <%--<tr>--%>
                <%--<td style="text-align: right">用户名：</td>--%>
                <%--<td style="text-align: left"><input type="text" name="username"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td style="text-align: right">密码：</td>--%>
                <%--<td style="text-align: left"><input type="password" name="password"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td style="text-align: right">地址：</td>--%>
                <%--<td style="text-align: left"><input type="text" name="address"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td style="text-align: right">电话：</td>--%>
                <%--<td style="text-align: left"><input type="text" name="phone"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td style="text-align: right">简介：</td>--%>
                <%--<td style="text-align: left"><input type="text" name="info"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td colspan="2" style="text-align: center">--%>
                    <%--<input type="submit" name="add" value="添加"/>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</table>--%>
    <%--</center>--%>
</form>
</body>
</html>
