<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <style>
        body {
            background-color: #faebd7;
        }
    </style>
</head>
<body>
<form action="login" method="post">
    <table align="center">
        <caption>登录界面</caption>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td colspan="8" align="center">
                <input  type="submit" value="登录">
<%--                <input  type="button" value="注册" onclick="regist()">--%>
                <input  type="reset" value="重置">
            </td>
        </tr>
        <tr>
            <td colspan="8"><span>${msg}</span></td>
        </tr>
    </table>
</form>
<script>
</script>
</body>
</html>
