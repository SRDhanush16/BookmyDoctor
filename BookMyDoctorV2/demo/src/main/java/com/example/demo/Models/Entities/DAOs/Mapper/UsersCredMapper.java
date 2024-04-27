package com.example.demo.Models.Entities.DAOs.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.Models.Entities.UsersCred;

public class UsersCredMapper implements RowMapper<UsersCred>{
	public UsersCred mapRow(ResultSet rs,int i) throws SQLException{
		
		UsersCred uc = new UsersCred();
		
		uc.setUid(rs.getInt("Uid"));
		uc.setUname(rs.getString("Uname"));
		uc.setUemail(rs.getString("Uemail"));
		uc.setUpassword(rs.getString("Upassword"));
		uc.setUphone(rs.getLong("Uphone"));
		
		return uc;
	}
}
