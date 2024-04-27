package com.example.demo.Models.Entities.DAOs.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.Models.Entities.DoctorCred;

public class DoctorsCredMapper implements RowMapper<DoctorCred>{
	public DoctorCred mapRow(ResultSet rs,int i) throws SQLException{
		DoctorCred dc = new DoctorCred();
		
		dc.setDid(rs.getInt("Did"));
		dc.setDname(rs.getString("Dname"));
		dc.setDemail(rs.getString("Demail"));
		dc.setDpassword(rs.getString("Dpassword"));
		
		return dc;
	}
	
	
}
