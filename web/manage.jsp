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
    <title>管理界面</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/search.udo" method="post">
    <center>
        <table border="" style="margin-top:50px; padding:30px">
            <tr>
                <td style="text-align: right">用户名：</td>
                <td style="text-align: left"><input type="text" name="username"/></td>
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
                <td colspan="2" style="text-align: center">
                    <input type="submit" name="search" value="搜索用户"/>
                    <a href="<%=request.getContextPath()%>/add.jsp">添加用户</a>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <a href="<%=request.getContextPath()%>/logout.udo">注销用户</a>
                </td>
            </tr>
        </table>
    </center>
</form>
<center>
    <table border="" style="padding:30px; margin-top:50px" cellpadding="10" cellspacing="0">
        <tr>
            <td>id</td>
            <td>用户名</td>
            <td>地址</td>
            <td>电话</td>
            <td>简介</td>
            <td>操作</td>
        </tr>
        <c:if test="${not empty users}">
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.address}</td>
                    <td>${user.phone}</td>
                    <td>${user.info}</td>
                    <td><a href="<%=request.getContextPath()%>/update.udo?id=${user.id}">修改</a> <a href="<%=request.getContextPath()%>/delete.udo?id=${user.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</center>
</body>
</html>
