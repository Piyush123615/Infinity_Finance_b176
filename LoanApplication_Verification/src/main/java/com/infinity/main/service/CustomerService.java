package com.infinity.main.service;

import org.springframework.web.multipart.MultipartFile;

import com.infinity.main.model.CustomerLoanApplication;

public interface CustomerService {

	public CustomerLoanApplication save_cla_details(String custJson, MultipartFile pancard, MultipartFile adharcard,
			MultipartFile photo, MultipartFile signature);

}
