<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%--
c:if  标签：
        1、必须属性：test，里面接收boolean表达式，
                *如果表达式为true则显示if标签体内容，日光为false则不显示标签体内容；
                *一般情况下text属性会结合el表达式一起使用；

--%>
<c:if test="true">
    <h1>woshizheng</h1>

</c:if>


<%

    //判断request域中的一个list集合是否为空，如果不为null则遍历集合
    List list = new ArrayList();
    request.setAttribute("list",list);
    list.add("aaa");
    request.setAttribute("number",3);

%>

<c:if test="${not empty list}">
    遍历集合
</c:if>

<c:if test="${number % 2 == 0}">
    ${number}为偶数

</c:if>
<c:if test="${number % 2 != 0}">
    ${number}为奇数

</c:if>
</body>
</html>
