<%--
  Created by IntelliJ IDEA.
  User: WWW
  Date: 11/26/2022
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new JSP</title>
</head>
<body>
<h1>Hello jsp</h1>

<%--Scriplet Using--%>
<%

    String name = "Ashan Manuka";
    int age = 22;

    System.out.println("Hello jsp !!!");
%>

<h1>my name is : <%= name%> </h1>
<h1>my age is : <%= age%> </h1>

</body>
</html>
