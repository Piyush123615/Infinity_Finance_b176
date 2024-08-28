package com.infinity.main.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinity.main.model.Admin;
import com.infinity.main.repository.AdminRepository;
import com.infinity.main.service.AdminService;
import com.infinity.main.utility.AdminUtility;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired private AdminRepository repository;
	
	@Override
	public Admin postAdmin(String adminJson, MultipartFile adminImage) {
		
		ObjectMapper mapper=new ObjectMapper();
		Admin admin=null;
		
		try {
			admin=mapper.readValue(adminJson, Admin.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(admin!=null)
		{
			try {
				admin.setAdminImage(adminImage.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		admin.setUsername(AdminUtility.setUsername(admin.getFirstName()));
		admin.setPassword(AdminUtility.setPassword(admin.getFirstName()));
		return repository.save(admin);
	}

	@Override
	public Admin getAdmin(String username, String password) {
		Admin ad=repository.findByUsernameAndPassword(username, password);
		if(ad==null)
		{
			throw new RuntimeException("Enter Valid Credentials!!!");
		}
		else
		{
			return ad;
		}
		
	}

	@Override
	public List<Admin> getAllAdmins() {
	    List<Admin> list = repository.findAll();
		return list;
	}

}
