package com.example.demo.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.Models.Entities.Appointments;
import com.example.demo.Services.UsersService;
import com.example.demo.Models.Entities.Appointments;
import com.example.demo.Models.Entities.DoctorsDetails;
//import com.example.demo.Models.Entities.DAOs.AppointmentsDAOImp;
import com.example.demo.Models.Forms.bookAppointment;
import com.example.demo.Models.Login.LoginResponse;


@RestController
//@CrossOrigin({"http://localhost:5173/Userpage","http://localhost:5173/cancelAppointment"})
@CrossOrigin("http://localhost:5173")
public class UserpageController {
	
	@Autowired
	UsersService UService;
	
	@PostMapping("/Userpage/Bookappointment")
	public boolean bookAppointment(@RequestBody bookAppointment req) {
		return UService.bookAppointment(req);
	}
	
	@PostMapping("/Userpage/ShowUserappointments")
	public List<Appointments> showUserappointments(@RequestBody LoginResponse resreq) {
		return UService.showUserAppointments(resreq);		
	}
	
	@PostMapping("/Userpage/Cancelappointment")
	public void cancelAppointment(@RequestBody Map<String,String> payload) {
		 int Aid = Integer.parseInt(payload.get("Aid"));
		UService.cancelAppointment(Aid); 
	}
	
	@GetMapping("/Userpage/getDoctors")
	public List<DoctorsDetails> getDoctors() {
		return UService.getDoctors();
	}
	
	
	
}
