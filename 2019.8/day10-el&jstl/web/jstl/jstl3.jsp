<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach循环</title>
</head>
<body>

<f:forEach begin="1" end="10" var="i" step="2">
    ${i}<br>

</f:forEach>

<%

    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list",list);
%>

<f:forEach items="${list}" var="str" varStatus="s">

    ${s.index}${s.count}${str}<br>

</f:forEach>





</body>
</html>
