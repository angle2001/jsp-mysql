<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewpoint">
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addServlet" method="post">
    <table border="1" cellpadding="3" cellspacing="0" align="center">
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td><input type="radio" name="gender" value="男">男
                <input type="radio" name="gender" value="女">女
            </td>
        </tr>
        <tr>
            <td>出生日期：</td>
            <td><input type="date" name="birthday"></td>
        </tr>
        <tr>
            <td colspan="8" align="center">
                <input type="submit" value="注册">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
