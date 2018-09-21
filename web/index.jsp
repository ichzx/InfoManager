<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 14455
  Date: 2018/9/17
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
  <center>
      <h1>欢迎你</h1>
  </center>
  <c:if test="${not empty requestScope.message}">
      <center>
      <span style="color: red">${message}</span>
      </center>
  </c:if>
  <form action="<%=request.getContextPath()%>/login.udo" method="post">
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
            <td colspan="2" style="text-align: center">
                <input type="submit" name="login"/>
                <a href="<%=request.getContextPath()%>/register.jsp">注册</a>
            </td>
        </tr>
    </table>
      </center>
  </form>
  </body>
</html>
