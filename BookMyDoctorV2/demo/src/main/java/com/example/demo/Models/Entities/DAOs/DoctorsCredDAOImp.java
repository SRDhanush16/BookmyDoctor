package com.example.demo.Models.Entities.DAOs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Models.Entities.DoctorCred;
import com.example.demo.Models.Entities.DAOs.Mapper.DoctorsCredMapper;

@Component
public class DoctorsCredDAOImp implements DoctorsCredDAO{
	
	@Autowired
	JdbcTemplate jdbc;
	
	public DoctorCred getDoctor(String email) {
		String query = "Select * from DoctorsCred where Demail=?";
		try {
			return jdbc.queryForObject(query, new Object[]{email},new DoctorsCredMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
