<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" charset=UTF-8">
<title>logout</title>

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
	<%if(session.getAttribute("username")!=null){
		session.invalidate();
	%>
	<jsp:include page="index.jsp"/>
	<b style="color:blue">Logged out Successfully..</b>
</body>
</html>
<%}
else
response.sendRedirect("login_form.jsp");
%>