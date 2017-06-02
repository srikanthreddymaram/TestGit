package com.pkg.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	private static Connection con=null;
	private static String url="jdbc:mysql://localhost:3306/";
	private static String username="root";
	private static String password="mysql";
	private static String driver="com.mysql.jdbc.Driver";
	
	public static Connection getConnection()
	{
		try{
		Class.forName(driver);
		con=DriverManager.getConnection(url,username,password);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
