package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Entities.Appointments;
import com.example.demo.Models.Entities.DAOs.AppointmentsDAOImp;
import com.example.demo.Models.Login.LoginResponse;

@Service
public class DoctorsService {
	
	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	AppointmentsDAOImp adaoi;
	
	public List<Appointments> showDoctorAppointments(LoginResponse resreq){	
		List<Appointments> doclist = adaoi.getAppointmentsforDoctor(resreq.getId());
		return doclist;		
	}
	
	public void finishAppointment(int Aid) {
		String query = "DELETE FROM Appointments WHERE Aid = ?";
		jdbc.update(query,Aid);
	}
	
}
