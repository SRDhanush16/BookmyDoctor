package com.example.demo.Services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Entities.Appointments;
import com.example.demo.Models.Entities.DoctorsDetails;
import com.example.demo.Models.Entities.DAOs.AppointmentsDAOImp;
import com.example.demo.Models.Entities.DAOs.DoctorsDetailsDAOImp;
//import com.example.demo.Models.Entities.Appointments;
import com.example.demo.Models.Forms.bookAppointment;
import com.example.demo.Models.Login.LoginResponse;

@Service
public class UsersService {
	
	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	AppointmentsDAOImp adaoi;
	
	@Autowired
	DoctorsDetailsDAOImp dddaoi; 
	
	public boolean bookAppointment(bookAppointment bareq) {
		try {
			Random rand = new Random();
			int Aid = rand.nextInt(999999);
			// Fetch Doctor ID (Did)
	        String fetchDid = "SELECT Did FROM DoctorsDetails WHERE Dname = ?";
	        Integer Did = jdbc.queryForObject(fetchDid, Integer.class, bareq.getDname());

	        jdbc.update("INSERT INTO Appointments (Aid, Uid, Pname, Patage, Uemail, pphone, Did, Dname, Adate, Atime) " +
	                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
	                Aid, bareq.getUid(), bareq.getPname(), bareq.getPatage(), bareq.getUemail(), bareq.getPphone(),
	                Did, bareq.getDname(), bareq.getAdate(), bareq.getAtime());

	        return true;
			
		}catch (EmptyResultDataAccessException e) {
	        System.out.println("No matching Doctor found for Dname: " + bareq.getDname());
	        return false;
	    } catch (Exception e) {
	        System.out.println("Error booking appointment: " + e.getMessage());
	        return false;
	    }
	}
	
	
	public List<Appointments> showUserAppointments(LoginResponse resreq){	
		List<Appointments> usrlist = adaoi.getAppointmentsforUser(resreq.getId());
		return usrlist;
		
	}
	
	public void cancelAppointment(int Aid) {
		String query = "DELETE FROM Appointments WHERE Aid = ?";
		jdbc.update(query,Aid);
	}
	
	
	public List<DoctorsDetails>getDoctors() {	
		 return dddaoi.getDoctorDetails();	
	}
	
}
