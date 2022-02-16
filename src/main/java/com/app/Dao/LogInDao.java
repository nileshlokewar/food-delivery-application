package com.app.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.app.dto.LoginDto;
import com.app.dto.UserProfile;
import com.mysql.cj.protocol.Resultset;

public class LogInDao {
	
	Connection con=null;
	PreparedStatement pstmt=null;
public LogInDao(){
	try {
		con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/swiggy","root","");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public UserProfile login(LoginDto user)throws Exception{
	pstmt =con.prepareStatement("select * from user where userName=? and password=?" );
	pstmt.setString(1, user.getUserName());
	pstmt.setString(2, user.getPassword());
	ResultSet rs=pstmt.executeQuery();
	UserProfile userProfile=new UserProfile();
	if (rs.next()) {
		userProfile.setName(rs.getString("userName"));
		userProfile.setEmail(rs.getString("email"));
		userProfile.setMobile(rs.getLong("mobile"));
		userProfile.setRole(rs.getString("role"));
		userProfile.setMsg("welcome to your profile."+rs.getString("userName") + "login successfully.");
		userProfile.setFlag(true);
		
		
	} else {
		System.out.println("sorry your not Register user you need to Register First");

	}
	return userProfile;
	
}
}
