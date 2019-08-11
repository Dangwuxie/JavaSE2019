<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lOGIN</title>
    <script>
        window.onload =function () {
            document.getElementById("img").onclick = function () {
                //点击二维码图片切换
                this.src="/day9/CheckCodeServlet?time="+new Date().getTime();
            }
        }

    </script>
    <style>
        div{
            color: crimson;
            size: A3;
        }
    </style>
</head>
<body>
    <form action="/day9/login3Servlet" method="post">
        <table>
                <tr>
                    <td>用户：</td>
                    <td><input type="text" name="username"> </td>
                </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"> </td>
            </tr>
            <tr>
                <td>验证码输入：</td>
                <td><input type="text" name="checkCode"> </td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="/day9/CheckCodeServlet"> </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登陆"> </td>
            </tr>
        </table>
    </form>
<div>
        <%=request.getAttribute("cc_error")%>
</div>
<div>
        <%=request.getAttribute("login_error")%>

</div>
</body>
</html>
