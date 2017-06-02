package com.pkg.userdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pkg.Connection.ConnectionManager;
import com.pkg.userbeans.UserBeans;

public class LoginDB {
	
	private static Connection con=null;
	private static Statement st=null;
	private static ResultSet rs=null;
	public static boolean authantication(UserBeans userBeans) {
		
		boolean flag=false;
		
		String uid=userBeans.getUser_id();
		String pass=userBeans.getPassword();
		
		String query="SELECT USERID,USERNAME,PASSWORD FROM SYS.USERDB WHERE USERID='"+uid+"' and PASSWORD='"+pass+"'";
		
		try{
			con=ConnectionManager.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(query);
			if(rs.next())
			{
				String uname=rs.getString("USERNAME");
				userBeans.setUser_name(uname);
				flag=true;
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}

		return flag;
	}

}
