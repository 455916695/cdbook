<%@ page import="com.ax.pojo.TbUser" %><%--
  Created by IntelliJ IDEA.
  User: ax

  Date: 2019/2/20
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    TbUser user = new TbUser();
    user.setId("2");
    request.getSession().setAttribute("user", user);
%>
<form action="/book/addBook" method="post">
    书名：<input type="text" name="name"></br>
    图片：<input type="text" name="image"></br>
    类型：<input type="text" name="cid"></br>
    <input type="submit" value="添加">
</form>
</body>
</html>
