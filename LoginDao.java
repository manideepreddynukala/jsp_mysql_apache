package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	String url = "jdbc:mysql://localhost:3316/manideep";  //database name
	String username = "root";
	String password = "manipinku95";
	String query = "select * from login where uname=? and password=?";
public boolean check(String uname,String pass) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,uname);
		pst.setString(2,pass);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			return true;
		}
	} 
	
	catch (Exception e) {
		
	}
	return false;
}
}
