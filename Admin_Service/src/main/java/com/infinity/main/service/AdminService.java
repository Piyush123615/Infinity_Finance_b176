package com.infinity.main.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.infinity.main.model.Admin;

public interface AdminService {

	public Admin postAdmin(String adminJson, MultipartFile adminImage);

	public Admin getAdmin(String username, String password);

	public List<Admin> getAllAdmin();

}
