package com.example.demo.Models.Entities.DAOs;

import java.util.List;

import com.example.demo.Models.Entities.Appointments;

public interface AppointmentsDAO {
	List<Appointments> getAppointmentsforUser(int id);
	List<Appointments> getAppointmentsforDoctor(int id);
}
