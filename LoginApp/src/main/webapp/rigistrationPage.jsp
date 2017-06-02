<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RegistrationPage</title>
</head>
<body>
	<button onclick="goBack()">Go Back</button>


	<form action="RegistrationServlet" method="post">
		UserId:<input type="text" name="userid" required> <br>
		UserName:<input type="text" name="username" required><br>
		Password:<input type="password" name="password" required><br>
		Email:<input type="email" name="email" required><br>
		Mobile Number:<input type="text" name="mobileno" pattern="[0-9]{10}"
			required title="Give 10 digit mobile no"><br> <input type="submit" value="SignUp">
	</form>

	<script>
		function goBack() {
			window.history.back();
		}
	</script>
</body>
</html>