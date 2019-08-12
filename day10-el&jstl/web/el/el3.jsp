<%@ page import="com.bit.day10.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取对象数据</title>
</head>
<body>
    <%
        User user = new User();
        user.setName("张三");
        user.setAge(22);
        user.setBirthday(new Date());


        request.setAttribute("userr",user);//键名，键的值

        List list = new ArrayList();
        list.add("hello");
        list.add("你好呀");
        list.add(user);

        request.setAttribute("list",list);

        Map map = new HashMap();
        map.put("sname","李四");
        map.put("gender","男");
        request.setAttribute("map",map);
    %>
<h3>获取对象的属性值</h3>
${requestScope.userr}
<br>
${requestScope.userr.name}
${requestScope.userr.age}
${requestScope.userr.birthday}
<br>
    <h2>获取list的值</h2>
${requestScope.list[0]}
${requestScope.list[1]}
${requestScope.list[2].name}<br>
<h2>获取map的值</h2>
${requestScope.map.sname}
${requestScope.map.gender}<br>
<h2>empty运算符</h2>
<%
    String str = "aaa";
    request.setAttribute("str",str);
%>

${empty str}

</body>
</html>
