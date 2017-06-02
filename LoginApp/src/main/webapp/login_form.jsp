
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LoginForm</title>
</head>
<body>
		<button onclick="goBack()">Go Back</button>

		<form action="LoginController" method="post">
		UserId:<input type="text" name="userid" required>
		Password:<input type="password" name="password" required>
	
		<input type="submit" value="SignIn">

		</form>
		<a href="forgotPass_from.jsp">Forgot Password?</a>
		<script>
function goBack() {
    window.history.back();
}
</script>
</body>
</html>