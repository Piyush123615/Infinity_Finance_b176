package com.infinity.main.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.infinity.main.model.CustomerLoanApplication;
import com.infinity.main.model.LoanStatus;
import com.infinity.main.service.CustomerService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;




@RestController
public class Customer_Controller {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("/save_cust")
	public ResponseEntity<CustomerLoanApplication> save_cust(@RequestPart("cust") String custJson,
			@RequestPart(value = "pan",required = false) MultipartFile pancard,
			@RequestPart(value = "adh",required = false) MultipartFile adharcard,
			@RequestPart(value = "pho",required = false) MultipartFile photo,
			@RequestPart(value = "sign",required = false) MultipartFile signature)
	{
		CustomerLoanApplication cla=service.save_cla_details(custJson,pancard,adharcard,photo,signature);
		return new ResponseEntity<CustomerLoanApplication>(cla, HttpStatus.CREATED);
	}
	

	@PatchMapping("/update_loan_status/{custid}/{newstatus}")
	public ResponseEntity<CustomerLoanApplication>update_loan_status(@PathVariable int custid,@PathVariable LoanStatus newstatus)
	{
		CustomerLoanApplication cla=service.update_loan_statusdetails(custid,newstatus);
		return new ResponseEntity<CustomerLoanApplication>(cla, HttpStatus.OK);
	}
	
    @PutMapping("/update_loanapp/{custid}")
    public ResponseEntity<CustomerLoanApplication>update_loanapp(@PathVariable int custid,@RequestPart("cust") String custJson,
			@RequestPart(value = "pan",required = false) MultipartFile pancard,
			@RequestPart(value = "adh",required = false) MultipartFile adharcard,
			@RequestPart(value = "pho",required = false) MultipartFile photo,
			@RequestPart(value = "sign",required = false) MultipartFile signature)
    {
    	CustomerLoanApplication cla=service.update_loanapp_details(custid,custJson,pancard,adharcard,photo,signature);
    	return new ResponseEntity<CustomerLoanApplication>(cla,HttpStatus.OK);
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerLoanApplication>> getAll(){
    	
    	List<CustomerLoanApplication> ca=service.getAllCustomerLoanDetails();
    	
    	return new ResponseEntity<List<CustomerLoanApplication>>(ca,HttpStatus.OK);
    	
    }
    
    @GetMapping("/getBy_CustomerId/{CustomerId}")
    public ResponseEntity<CustomerLoanApplication> getByCustomerId(@PathVariable int CustomerId){
    	
    	CustomerLoanApplication ca=service.getCustomerLoanApplicationByCustomerId(CustomerId);
    	
    	return new ResponseEntity<CustomerLoanApplication>(ca,HttpStatus.OK);
    }
    
    @GetMapping("/getBy_LoanStatus/{status}")
    public ResponseEntity<CustomerLoanApplication> getByLoanStatus(@PathVariable LoanStatus status){
    	
    	CustomerLoanApplication ca=service.getCustomerLoanApplicationByLoanStatus(status);
    	
    	return new ResponseEntity<CustomerLoanApplication>(ca,HttpStatus.OK);
    }
    
    
	@DeleteMapping("/deleteLoan/{customerId}")
	@Transactional
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId)
	{
		service.deleteCustomerByID(customerId);
		return new ResponseEntity<String>("Deleted Customer Loan Form",HttpStatus.OK);
		
	}


}
