<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>用户注册</h1>
<form action="registerServlet" method="post">
    用户名: <input type="text" name="username" required><br>
    密码: <input type="password" name="password" required><br>
    邮箱: <input type="email" name="email" required><br>
    <button type="submit">注册</button>
</form>
</body>
</html>
