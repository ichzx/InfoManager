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
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <title>登录</title>
  </head>
  <body>
  <h1 class="display-1">Welcome</h1>
  <c:if test="${not empty requestScope.message}">
      <center>
      <span style="color: red">${message}</span>
      </center>
  </c:if>
  <form action="<%=request.getContextPath()%>/login.udo" method="post">
      <div class="form-group">
          <label style="margin-left: 10px">Username:</label>
          <input type="text" class="form-control" style="width: 200px; margin-left: 10px;" name="username"/>
      </div>
      <div class="form-group">
          <label style="margin-left: 10px">Password:</label>
          <input type="password" class="form-control" style="width: 200px; margin-left: 10px" name="password"/>
      </div>
      <button type="submit" class="btn btn-primary" style="margin-left: 10px">Login</button>
      <a href="<%=request.getContextPath()%>/register.jsp" class="btn btn-success">Register</a>
  </form>
  </body>
</html>
