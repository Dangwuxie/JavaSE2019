<%--
  Created by IntelliJ IDEA.
  User: dangwuxie
  Date: 2019/8/11
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h1>
        <%=request.getSession().getAttribute("username")%>,欢迎你回来!!!
    </h1>
</body>
</html>
