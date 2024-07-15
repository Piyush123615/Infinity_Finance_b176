package com.infinity.main.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinity.main.model.AccountDetails;
import com.infinity.main.model.AllPersonalDocuments;
import com.infinity.main.model.CustomerAddress;
import com.infinity.main.model.CustomerLoanApplication;
import com.infinity.main.model.FamilyDependentInfo;
import com.infinity.main.model.GuarantorDetails;
import com.infinity.main.model.LoanStatus;
import com.infinity.main.repository.CustomerRepository;
import com.infinity.main.service.CustomerService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public CustomerLoanApplication save_cla_details(String custJson, MultipartFile pancard, MultipartFile adharcard,
			MultipartFile photo, MultipartFile signature) {
		
		ObjectMapper mapper=new ObjectMapper();
		@Valid	
		CustomerLoanApplication custloanapp=null;
	    AllPersonalDocuments apd=new AllPersonalDocuments();
	    
		try {
			
		custloanapp=mapper.readValue(custJson, CustomerLoanApplication.class);
		
		 Validator validator = Validation.buildDefaultValidatorFactory().getValidator(); 
		 Set<ConstraintViolation<CustomerLoanApplication>> violations;
		
			violations = validator.validate(custloanapp);
			   if (!violations.isEmpty()) 
			   {
			        throw new ConstraintViolationException(violations);
		
			
		
		
		}
		}catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			apd.setPancard(pancard.getBytes());
		

			apd.setAdharcard(adharcard.getBytes());

			apd.setPhoto(photo.getBytes());

			apd.setSign(signature.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(apd!=null) custloanapp.setAllpersonaldocs(apd);

		custloanapp.setStatus(LoanStatus.CREATED);
		
		return repository.save(custloanapp);
		
//		return null;
	}
	

	@Override

	public CustomerLoanApplication update_loan_statusdetails(int custid, LoanStatus newstatus) {
		Optional<CustomerLoanApplication> op = repository.findById(custid);
		if(op.isEmpty())
		{
			throw new RuntimeException("Customer ID not Found!!!");
		}
		else
		{
			CustomerLoanApplication c=op.get();
			c.setStatus(newstatus);
			return repository.save(c);
			
		}
		
	}

	@Override
	public CustomerLoanApplication update_loanapp_details(int custid, String custJson, MultipartFile pancard,
			MultipartFile adharcard, MultipartFile photo, MultipartFile signature) {
		
		Optional<CustomerLoanApplication> op= repository.findById(custid);
		CustomerLoanApplication c=null;
		CustomerLoanApplication custloanapp=null;
		AllPersonalDocuments apd=new AllPersonalDocuments();
		ObjectMapper mapper=new ObjectMapper();
		
		if(op.isEmpty()) {
			throw new RuntimeException("Customer ID not Found!!!");
		}
		else {
			 
			     c=  op.get();
			     if(c.getCustomerId()==custid)
			     {
			 	    
			 		try {
			 			
			 			custloanapp=mapper.readValue(custJson, CustomerLoanApplication.class);
			 			System.out.println(custloanapp);
			 		
			 		} catch (JsonProcessingException e) {
			 			// TODO Auto-generated catch block
			 			e.printStackTrace();
			 		}
			 		
			 		try {
			 			apd.setPancard(pancard.getBytes());
			 		

			 			apd.setAdharcard(adharcard.getBytes());

			 			apd.setPhoto(photo.getBytes());

			 			apd.setSign(signature.getBytes());
			 		    custloanapp.setAllpersonaldocs(apd);
			 		} catch (IOException e) {
			 			// TODO Auto-generated catch block
			 			e.printStackTrace();
			 		}
			 		
			 		
			     }
			     custloanapp.setCustomerId(custid);
			     custloanapp.getAllpersonaldocs().setDocumentId(c.getAllpersonaldocs().getDocumentId());
			 
			     return repository.save(custloanapp);   
		}
		
	
	}

	@Override
	public List<CustomerLoanApplication> getAllCustomerLoanDetails() {

		Iterable<CustomerLoanApplication> ca=repository.findAll();
		
		return (List<CustomerLoanApplication>) ca;
	}

    @Override
	public CustomerLoanApplication getCustomerLoanApplicationByCustomerId(int customerId) {

		CustomerLoanApplication ca=repository.findByCustomerId(customerId);
		
		return ca;
	}

	@Override
	public CustomerLoanApplication getCustomerLoanApplicationByLoanStatus(LoanStatus status) {

		CustomerLoanApplication ca=repository.findByStatus(status);
		
		return ca;
	}

	@Override
	public void deleteCustomerByID(int customerId) {

	repository.deleteByCustomerId(customerId);
		

	}

}
