 <%@page import="com.pkg.Connection.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.Statement"  %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <%if(session.getAttribute("username")!=null)
  {
	  %>  
  
    <%
    	Connection con=null;
    	ResultSet rs=null;
    	Statement st=null;
    	String query="SELECT USERID,USERNAME,EMAIL,MOBILENO from SYS.USERDB";
    	try
    	{
    		con=ConnectionManager.getConnection();
    		st=con.createStatement();
    		rs=st.executeQuery(query);
    		%>
    	
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserDetails</title>
<style>
table, td, th {    
    border: 1px solid #ddd;
    text-align: left;
}

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 15px;
}
</style>
</head>
<body>
<table>
		<tr>
		<th>UserId</th>
		<th>UserName</th>
		<th>Email</th>
		<th>MobileNo</th>
		</tr>
			<%
			
			while(rs.next())
    		{
    			%>
    		<tr>	
    		<td><%=rs.getString(1) %></td>	
    		<td><%=rs.getString(2) %></td>
    		<td><%=rs.getString(3) %></td>
    		<td><%=rs.getString(4) %></td>	
    		</tr>

    			<%
    		}
    		
    		getServletContext().log("Here we are getting all ther users details");%>
    		</table>
    	<%	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		    
    %>
    <button onclick="goBack()">Go Back</button>
	<script>
			function goBack() {
   			 window.history.back();
				}
	</script>
</table>
</body>
</html>
<%}
else
response.sendRedirect("http://localhost:2020/LoginApp/login_form.jsp");%>