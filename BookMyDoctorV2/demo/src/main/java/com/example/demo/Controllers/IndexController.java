package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Login.LoginRequest;
import com.example.demo.Models.Login.LoginResponse;
import com.example.demo.Models.Login.createAccountRequest;
import com.example.demo.Services.LoginService;

@RestController
@CrossOrigin("http://localhost:5173")
public class IndexController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/Userslogin")
	public LoginResponse loginCheckUser(@RequestBody LoginRequest req) {
		return loginService.checkUser(req);
	}
	
	@PostMapping("/Doctorslogin")
	public LoginResponse loginCheckDoctor(@RequestBody LoginRequest req) {
		return loginService.checkDoctor(req);
	}
	
	@PostMapping("/Createaccount")
	public boolean createAccount(@RequestBody createAccountRequest req ) {
		return loginService.addUser(req);
	}
	
}
