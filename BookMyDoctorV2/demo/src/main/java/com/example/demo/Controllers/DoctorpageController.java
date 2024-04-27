package com.example.demo.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Entities.Appointments;
import com.example.demo.Models.Login.LoginResponse;
import com.example.demo.Services.DoctorsService;

@RestController
@CrossOrigin("http://localhost:5173")
public class DoctorpageController {
	
	@Autowired
	DoctorsService docService;
	
	@PostMapping("/Doctorpage/ShowDoctorappointments")
	public List<Appointments> showDoctorappointments(@RequestBody LoginResponse resreq){
		return docService.showDoctorAppointments(resreq);
	}
	
	@PostMapping("/Doctorpage/Finishappointment")
	public void finishAppointment(@RequestBody Map<String,String> payload) {
		 int Aid = Integer.parseInt(payload.get("Aid"));
		 docService.finishAppointment(Aid); 
	}
	
}
