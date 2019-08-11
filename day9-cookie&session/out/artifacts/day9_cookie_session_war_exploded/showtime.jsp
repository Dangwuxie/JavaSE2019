<%@ page import="java.util.Date" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    boolean flag = false;//没有cookie为lastTime
    //1、获取所有的cookie
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length>0){
        for (Cookie cookie:cookies){

            //获取所有的cookie名称
            String name = cookie.getName();
            //判断名称是否是lastTime
            if ("lastTime".equals(name)){
                //有，不是第一次访问
                flag = true;
                //设置cookie的value,获取当前的时间的字符串，重新设置cookie的值
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String str_date = sdf.format(date);
                str_date = URLEncoder.encode(str_date,"utf-8");
                cookie.setValue(str_date);

                //设置cookie存活时间
                cookie.setMaxAge(200);
                response.addCookie(cookie);

                //响应数据，“欢迎回来”，获取cookie的数据，value(时间)
                String value = cookie.getValue();
                value = URLDecoder.decode(value,"utf-8");
                //中文数据在响应前需要设置响应体的编码数据格式
                %>

                    <h1 style="color: darkmagenta">22222欢迎回来，您上次的访问时间为<%=value%></h1>
<%
                break;
            }
        }
    }
    if (cookies == null ||cookies.length==0||flag==false){
        //第一次
        //设置cookie的value,获取当前的时间的字符串，重新设置cookie的值
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);
        str_date = URLEncoder.encode(str_date,"utf-8");
        Cookie cookie = new Cookie("lastTime",str_date);
        //设置cookie存活时间
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        out.write("<h1>欢迎您首次登陆！！！2222222</h1>");


    }
%>

</body>
</html>
