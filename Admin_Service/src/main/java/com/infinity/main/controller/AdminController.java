package com.infinity.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.infinity.main.model.Admin;
import com.infinity.main.service.AdminService;

@RestController
@RequestMapping("/admin-details")
@CrossOrigin("*")
public class AdminController {

	@Autowired private AdminService service;
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> saveAdmin(@RequestPart ("adminJson") String adminJson,
			                                @RequestPart ("adminImage") MultipartFile adminImage)
	{
		Admin ad=service.postAdmin(adminJson,adminImage);
		return new ResponseEntity<Admin>(ad, HttpStatus.CREATED);
	}
	
	@GetMapping("/admin/{username}/{password}")
	public ResponseEntity<Admin> getAdmin(@PathVariable String username,@PathVariable String password)
	{
		Admin ad=service.getAdmin(username,password);
		return new ResponseEntity<Admin>(ad, HttpStatus.OK);
	}

}

