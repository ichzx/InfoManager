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
    <title>添加用户</title>
</head>
<body>
<c:if test="${not empty requestScope.message}">
    <center>
        <span style="color: red">${message}</span>
    </center>
</c:if>
<form action="<%=request.getContextPath()%>/add.udo" method="post">
    <center>
        <table border="" style="margin-top: 50px; padding: 30px">
            <tr>
                <td style="text-align: right">用户名：</td>
                <td style="text-align: left"><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td style="text-align: right">密码：</td>
                <td style="text-align: left"><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td style="text-align: right">地址：</td>
                <td style="text-align: left"><input type="text" name="address"/></td>
            </tr>
            <tr>
                <td style="text-align: right">电话：</td>
                <td style="text-align: left"><input type="text" name="phone"/></td>
            </tr>
            <tr>
                <td style="text-align: right">简介：</td>
                <td style="text-align: left"><input type="text" name="info"/></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <input type="submit" name="add" value="添加"/>
                </td>
            </tr>
        </table>
    </center>
</form>
</body>
</html>
