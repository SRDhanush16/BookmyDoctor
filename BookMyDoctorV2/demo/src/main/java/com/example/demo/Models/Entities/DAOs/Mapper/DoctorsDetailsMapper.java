package com.example.demo.Models.Entities.DAOs.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.Models.Entities.DoctorsDetails;

public class DoctorsDetailsMapper implements RowMapper<DoctorsDetails>{
	public DoctorsDetails mapRow(ResultSet rs,int i) throws SQLException {
		DoctorsDetails dd = new DoctorsDetails();
		
		dd.setDid(rs.getInt("Did"));
		dd.setDname(rs.getString("Dname"));
		dd.setDemail(rs.getString("Demail"));
		dd.setSpecialzation(rs.getString("specialzation"));
		
		dd.setShift(rs.getString("shift"));
		dd.setSlot1(rs.getString("slot1"));
		
		dd.setSlot2(rs.getString("slot2"));
		
		
		return dd;
	}
}
