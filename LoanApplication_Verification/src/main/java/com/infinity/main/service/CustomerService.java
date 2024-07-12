package com.infinity.main.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.infinity.main.model.CustomerLoanApplication;
import com.infinity.main.model.LoanStatus;

public interface CustomerService {

	public CustomerLoanApplication save_cla_details(String custJson, MultipartFile pancard, MultipartFile adharcard,
			MultipartFile photo, MultipartFile signature);

	public CustomerLoanApplication update_loan_statusdetails(int custid, LoanStatus newstatus);

	public CustomerLoanApplication update_loanapp_details(int custid, String custJson, MultipartFile pancard,
			MultipartFile adharcard, MultipartFile photo, MultipartFile signature);

	public List<CustomerLoanApplication> getAllCustomerLoanDetails();

	public CustomerLoanApplication getCustomerLoanApplicationByCustomerId(int customerId);

	public CustomerLoanApplication getCustomerLoanApplicationByLoanStatus(LoanStatus status);

}
