package com.example.demo.Models.Entities.DAOs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Models.Entities.DoctorsDetails;
import com.example.demo.Models.Entities.DAOs.Mapper.DoctorsDetailsMapper;

@Component
public class DoctorsDetailsDAOImp implements DoctorsDetailsDAO{
	
	@Autowired
	JdbcTemplate jdbc;
	
	// for fetching all the doctor
	public List<DoctorsDetails> getDoctorDetails() {
		String query = "Select * from DoctorsDetails";
		try {
			 return jdbc.query(query, new DoctorsDetailsMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		
	}
	
	// for single Doctor
	public DoctorsDetails getDoctorDetail(int id) {
	    String query = "SELECT * FROM DoctorsDetails WHERE Did = ?";
	    try {
	        return jdbc.queryForObject(query, new Object[] { id }, new DoctorsDetailsMapper());
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	}
	
}
