<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/8/27
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
<form action="updateServlet" method="post">
    <table border="1" cellpadding="3" cellspacing="0" align="center">
<%--        隐藏域--%>
        <input type="hidden" name="hid" value="${user.id}">
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="name" value="${user.name}"></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"  value="${user.username}" ></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password" value="${user.password}"></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input type="text" name="age"value="${user.age}"></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td><input type="radio" name="gender" value="男"
            <c:if test="${user.gender eq '男'}">checked</c:if> >男
                <input type="radio" name="gender" value="女"
                <c:if test="${user.gender eq '女'}">checked</c:if> >女
            </td>
        </tr>
        <tr>
            <td>出生日期：</td>
            <td><input type="date" name="birthday" value="${user.birthday}"></td>
        </tr>
        <tr>
            <td colspan="8" align="center">
                <input type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
