package com.example.demo.Models.Entities.DAOs;

import java.util.List;

import com.example.demo.Models.Entities.DoctorsDetails;

public interface DoctorsDetailsDAO {
	List<DoctorsDetails> getDoctorDetails();
	DoctorsDetails getDoctorDetail(int id);
}
