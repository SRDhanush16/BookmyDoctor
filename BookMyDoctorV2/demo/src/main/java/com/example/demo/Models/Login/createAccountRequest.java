package com.example.demo.Models.Login;

public class createAccountRequest {
	private String uname;
	private String uemail;
	private String upassword;
	private Long uphone;
	
//	public createAccountRequest(String uname, String uemail,String upassword,Long uphone) {
//		Uname = uname;
//		Uemail = uemail;
//		Upassword = upassword;
//		Uphone = uphone;
//	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public Long getUphone() {
		return uphone;
	}
	public void setUphone(Long uphone) {
		this.uphone = uphone;
	}
	
	
}
