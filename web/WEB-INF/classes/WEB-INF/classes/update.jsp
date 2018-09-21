<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 14455
  Date: 2018/9/20
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<c:if test="${not empty requestScope.message}">
    <center>
        <span style="color: red">${message}</span>
    </center>
</c:if>
<form action="<%=request.getContextPath()%>/updateDone.udo?id=${userInfo.id}" method="post">
    <center>
        <table border="" style="margin-top: 50px; padding: 30px">
            <tr>
                <td style="text-align: right">用户名：</td>
                <td style="text-align: left"><input type="text" name="username" value="${userInfo.username}"/></td>
            </tr>
            <tr>
                <td style="text-align: right">密码：</td>
                <td style="text-align: left"><input type="text" name="password" value="${userInfo.password}"/></td>
            </tr>
            <tr>
                <td style="text-align: right">地址：</td>
                <td style="text-align: left"><input type="text" name="address" value="${userInfo.address}"/></td>
            </tr>
            <tr>
                <td style="text-align: right">电话：</td>
                <td style="text-align: left"><input type="text" name="phone" value="${userInfo.phone}"/></td>
            </tr>
            <tr>
                <td style="text-align: right">简介：</td>
                <td style="text-align: left"><input type="text" name="info" value="${userInfo.info}"/></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <input type="submit" name="add" value="修改"/>
                </td>
            </tr>
        </table>
    </center>
</form>
</body>
</html>
