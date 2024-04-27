package com.example.demo.Models.Entities.DAOs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Models.Entities.UsersCred;
import com.example.demo.Models.Entities.DAOs.Mapper.UsersCredMapper;

@Component
public class UsersCredDAOImp implements UsersCredDAO {
	
	@Autowired
	JdbcTemplate jdbc;
	
	public UsersCred getUser(String email) {
		String query = "Select * from UsersCred where Uemail=?";
		try {
			return jdbc.queryForObject(query,new Object[] {email}, new UsersCredMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
