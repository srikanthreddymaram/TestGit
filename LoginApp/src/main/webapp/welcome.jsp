<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%if(session.getAttribute("username")!=null)
    	{%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>

<style>
a:link, a:visited {
    background-color: #f4a442;
    color: white;
    padding: 14px 25px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
}
a:hover, a:active {
    background-color: #ff9a1e;
}
</style>
</head>
<body>
		<a href="http://localhost:2020/LoginApp/user_details.jsp">userdetails</a>
		<a href="http://localhost:2020/LoginApp/logout.jsp">Logout</a>
		<h1><b style="color:green">welcome:&nbsp;<%=session.getAttribute("username") %></b></h1>
		
</body>
</html>
<%}
    else
    	response.sendRedirect("http://localhost:2020/LoginApp/login_form.jsp");
%>