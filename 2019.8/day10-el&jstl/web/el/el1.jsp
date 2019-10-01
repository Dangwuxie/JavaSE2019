<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL1</title>
</head>
<body>

    ${3 > 4}

<h1>算术运算符</h1>
    ${3 + 4}
    ${3 - 4}
    ${3 * 4}
    ${3 / 4}
    ${3 div 4}
    ${3 mod 4}
    ${3 % 4}
<h1>比较运算符</h1>
${3 == 4}

    <h1>逻辑运算符</h1>
    ${3 > 4 && 3 < 4}
    ${3 > 4 || 3 < 4}
    ${! (3 > 4)}
<%

%>

</body>
</html>
