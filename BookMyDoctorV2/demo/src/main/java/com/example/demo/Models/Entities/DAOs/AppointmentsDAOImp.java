package com.example.demo.Models.Entities.DAOs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Models.Entities.Appointments;
import com.example.demo.Models.Entities.DAOs.Mapper.AppointmentsMapper;

@Component
public class AppointmentsDAOImp implements AppointmentsDAO {
	
	@Autowired
	JdbcTemplate jdbc;
	
	
	public List<Appointments> getAppointmentsforUser(int id) {
	    String query = "SELECT * FROM Appointments WHERE Uid=?";
	    try {
	        return jdbc.query(query, new Object[] {id}, new AppointmentsMapper());
	    } catch(EmptyResultDataAccessException e) {
	        return null;
	    }
	}
	
	public List<Appointments> getAppointmentsforDoctor(int id) {
	    String query = "SELECT * FROM Appointments WHERE Did=?";
	    try {
	        return jdbc.query(query, new Object[] {id}, new AppointmentsMapper());
	    } catch(EmptyResultDataAccessException e) {
	        return null;
	    }
	}
	
	
	
}
