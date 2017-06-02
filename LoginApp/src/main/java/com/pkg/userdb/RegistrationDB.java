package com.pkg.userdb;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pkg.Connection.ConnectionManager;
import com.pkg.userbeans.UserBeans;

public class RegistrationDB {
	
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static String Query="INSERT INTO SYS.USERDB VALUES(?,?,?,?,?)";
	public static boolean registerUser(UserBeans userBeans) {
		
		boolean flag=false;
		
		
		String uid=userBeans.getUser_id();
		String uname=userBeans.getUser_name();
		String pass=userBeans.getPassword();
		String email=userBeans.getEmail_id();
		String mobileno=userBeans.getMobile_no();
		
		
		
		
		
		try{
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(Query);
			
			ps.setString(1, uid);
			ps.setString(2, uname);
			ps.setString(3, pass);
			ps.setString(4, email);
			ps.setString(5, mobileno);
			int resultSet=ps.executeUpdate();
			if(resultSet!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}

}
