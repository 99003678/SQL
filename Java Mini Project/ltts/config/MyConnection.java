package com.ltts.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	
	public static Connection getConnection() throws Exception
	{
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ashu","root","root");
		return con;
		
	}
	

}