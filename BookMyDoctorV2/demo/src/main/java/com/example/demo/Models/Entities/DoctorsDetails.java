package com.example.demo.Models.Entities;

public class DoctorsDetails {
	private int Did;
	private String Dname;
	private String Demail;
	private String specialzation;
	private String shift;
	private String slot1;
	private String slot2;
	
	public int getDid() {
		return Did;
	}
	public void setDid(int did) {
		Did = did;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	public String getDemail() {
		return Demail;
	}
	public void setDemail(String demail) {
		Demail = demail;
	}
	public String getSpecialzation() {
		return specialzation;
	}
	public void setSpecialzation(String specialzation) {
		this.specialzation = specialzation;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getSlot1() {
		return slot1;
	}
	public void setSlot1(String slot1) {
		this.slot1 = slot1;
	}
	public String getSlot2() {
		return slot2;
	}
	public void setSlot2(String slot2) {
		this.slot2 = slot2;
	}
	
}
