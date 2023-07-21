package com.mvc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoRepository {
	
	public List<Map<String, String>> selectUserInfoList() {
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/kd";
		String user = "root";
		String pwd = "kd1824java";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<Map<String,String>> UserInfoList = new ArrayList<>();
		try {
			
			Connection con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM USER_INFO WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> userInfo = new HashMap<>();
				userInfo.put("uiNum", rs.getString("UI_NUM"));
				userInfo.put("uiId", rs.getString("UI_ID"));
				userInfo.put("uiPwd", rs.getString("UI_PWD"));
				userInfo.put("uiName", rs.getString("UI_NAME"));
				UserInfoList.add(userInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UserInfoList;
		}
	
	
	
	public static void main(String[] args) {
		UserInfoRepository ciRepo = new UserInfoRepository();
		List<Map<String,String>> userInfoList = ciRepo.selectUserInfoList();
		for(Map<String,String> userInfo : userInfoList) {
			System.out.println(userInfo.get("uiNum"));
			System.out.println(userInfo.get("uiId"));
			System.out.println(userInfo.get("uiPwd"));
			System.out.println(userInfo.get("uiName"));
		}
	}
}
