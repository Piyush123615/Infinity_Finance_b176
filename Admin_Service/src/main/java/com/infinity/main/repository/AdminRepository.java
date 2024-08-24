package com.infinity.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinity.main.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{
	
	public Admin findByUsernameAndPassword(String username,String password);

}
