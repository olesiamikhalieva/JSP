<%@ page import="com.StudentArray" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
<%
    for (String s : StudentArray.getArrayStudentName()) {
        out.print(s);
    }

%>
</h1>
</body>
</html>