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

import com.mvc.common.DBCon;

public class ClassInfoRepository {

	public List<Map<String,String>> selectClassInfoList() {
		List<Map<String,String>> classInfoList = new ArrayList<>();
		
		try {
			Connection con = DBCon.getCon();

			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet  rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> classInfo = new HashMap<>();
				classInfo.put("ciNum", rs.getString("CI_NUM"));
				classInfo.put("ciName", rs.getString("CI_NAME"));
				classInfo.put("ciDesc", rs.getString("CI_DESC"));
				classInfoList.add(classInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classInfoList;
		
	}


	public Map<String,String> selectClassInfo() {
		
		
		try {
			Connection con = DBCon.getCon();

			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet  rs = ps.executeQuery();
			if(rs.next()) {
				Map<String,String> classInfo = new HashMap<>();
				classInfo.put("ciNum", rs.getString("CI_NUM"));
				classInfo.put("ciName", rs.getString("CI_NAME"));
				classInfo.put("ciDesc", rs.getString("CI_DESC"));
				return classInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}