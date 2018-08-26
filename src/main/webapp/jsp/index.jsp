<%@page contentType="text/html;charset=utf-8"%>
<%@page isELIgnored="false" %>
<%@page import="java.util.List,tree.domain.User"%>
<html>
<body>
<form action="select" method="post">
    <p><input type="text" name="id"></p>
    <input type="submit" value="select">
</form>
<%
    List<User>result=(List<User>)request.getAttribute("result");
    if(result!=null){
        for(User user:result)
            out.print(user+"<br>");
    }
%>
    <a href="/management.jsp">go to manage</a>
</body>
</html>