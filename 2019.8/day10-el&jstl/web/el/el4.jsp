<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el隐式对象</title>
</head>
<body>
        //在jsp页面动态获取虚拟目录
        ${pageContext.response}<br>

        <h1>获取虚拟地址</h1>
        ${pageContext.request.contextPath}

</body>
</html>
