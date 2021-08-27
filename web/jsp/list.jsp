<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员信息</title>
</head>
<body>
<form action="findByConditionServlet" align="center">
    姓名：<input type="text" name="name">
    男：<input type="radio" name="gender" value="男">
    女：<input type="radio" name="gender" value="女">
    年龄：<input type="text" name="age">
    <input type="submit" value="搜索">


</form>
<form action="deleteByIds" onsubmit="return del()">
    <table align="center" border="1" cellspacing="0" cellpadding="5">
        <tr>
            <td colspan="8" align="right">
                <input type="button" value="新增用户" onclick="add()">
                <input type="submit" value="删除选中">
            </td>
        </tr>
        <tr>
            <th><input type="checkbox" name="ck"></th>
            <th>编号</th>
            <th>性名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>生日</th>
            <th>用户名</th>
            <th>密码</th>
            <th>操作</th>
        </tr>
        <c:if test="${not empty list}">
            <c:forEach items="${list}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="ck" value="${user.id}"></td>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.gender}</td>
                    <td>${user.birthday}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>
                        <a href="updateUserServlet?id=${user.id}">修改</a>
                        <a href="deleteUserServlet?id=${user.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</form>
<script>
    function add() {
        location.href = "jsp/add.jsp";
    }

    function del() {
        if (confirm("您确定真的要删除吗")) {
            return true;
        }
        return false;
    }
</script>
</body>
</html>
