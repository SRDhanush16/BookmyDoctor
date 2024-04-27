package com.example.demo.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Entities.DoctorCred;
import com.example.demo.Models.Entities.UsersCred;
import com.example.demo.Models.Entities.DAOs.DoctorsCredDAOImp;
import com.example.demo.Models.Entities.DAOs.UsersCredDAOImp;
import com.example.demo.Models.Login.LoginRequest;
import com.example.demo.Models.Login.LoginResponse;
import com.example.demo.Models.Login.createAccountRequest;

@Service
public class LoginService {
	
	@Autowired
	UsersCredDAOImp ucdaoi;
	
	@Autowired 
	DoctorsCredDAOImp dcdaoi;
	
	@Autowired
	JdbcTemplate jdbc;
	
	public LoginResponse checkUser(LoginRequest req) {
		LoginResponse lr = new LoginResponse();
		UsersCred user = ucdaoi.getUser(req.getEmail());
		if(user != null && user.getUpassword().equals(req.getPassword())) {
			lr.setId(user.getUid());
			lr.setUsername(user.getUname());
			lr.setEmail(user.getUemail());
			lr.setFlag(true);
		} else {
			lr.setId(-1);
			lr.setUsername("invalid");
			lr.setEmail("invalid");
			lr.setFlag(false);
		}
		return lr;
	}
	
	public LoginResponse checkDoctor(LoginRequest req) {
		LoginResponse lr = new LoginResponse();
		DoctorCred doctor = dcdaoi.getDoctor(req.getEmail());
		if(doctor != null && doctor.getDpassword().equals(req.getPassword())) {
			lr.setId(doctor.getDid());
			lr.setUsername(doctor.getDname());
			lr.setEmail(doctor.getDemail());
			lr.setFlag(true);
		}else {
			lr.setId(-1);
			lr.setUsername("invalid");
			lr.setEmail("invalid");
			lr.setFlag(false);
		}
		return lr;
	}
	
	public boolean addUser(createAccountRequest req) {
	    try {
	        Integer lastUserId = jdbc.queryForObject("SELECT MAX(Uid) FROM UsersCred", Integer.class);
	        int newUserId = (lastUserId != null) ? lastUserId + 1 : 1;

	        jdbc.update("INSERT INTO UsersCred (Uid, Uname, Uemail, Upassword, Uphone) VALUES (?, ?, ?, ?, ?)",
	                newUserId, req.getUname(), req.getUemail(), req.getUpassword(), req.getUphone());
	        System.out.println("User Created Successfully");
	        return true;
	    } catch (Exception e) {
	        System.err.println("Error creating user: " + e.getMessage());
	        return false;
	    }
	}

	
}
