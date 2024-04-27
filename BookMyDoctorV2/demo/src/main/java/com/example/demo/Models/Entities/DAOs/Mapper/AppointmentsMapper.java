package com.example.demo.Models.Entities.DAOs.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.example.demo.Models.Entities.Appointments;

public class AppointmentsMapper implements RowMapper<Appointments>{
	public Appointments mapRow(ResultSet rs , int i) throws SQLException {
		Appointments a = new Appointments();
		
		a.setAid(rs.getInt("Aid"));
		a.setUid(rs.getInt("Uid"));
		a.setPname(rs.getString("Pname"));
		a.setPatage(rs.getInt("Patage"));
		a.setUemail(rs.getString("Uemail"));
		a.setPphone(rs.getLong("pphone"));
		a.setDid(rs.getInt("Did"));
		a.setDname(rs.getString("Dname"));
		a.setAdate(rs.getString("Adate"));
		a.setAtime(rs.getString("Atime"));
		
		
		return a;
	}
}
