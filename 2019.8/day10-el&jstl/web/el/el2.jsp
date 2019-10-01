<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el来获取域中的数据</title>
</head>
<body>
    <%
        session.setAttribute("name","张三");
        //在于中存储数据
        request.setAttribute("name","张san");
        session.setAttribute("age",22);


    %>

<h3>el获取值</h3>
${requestScope.name}
${sessionScope.age}
${sessionScope.haha}

<br>
<br>
${name}
</body>
</html>
