package com.infinity.main.serviceimpl;

import java.io.IOException;
import java.util.Optional;

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

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public CustomerLoanApplication save_cla_details(String custJson, MultipartFile pancard, MultipartFile adharcard,
			MultipartFile photo, MultipartFile signature) {
		
		ObjectMapper mapper=new ObjectMapper();
		CustomerLoanApplication custloanapp=null;
	    AllPersonalDocuments apd=new AllPersonalDocuments();
	    
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(apd!=null) custloanapp.setAllpersonaldocs(apd);

		custloanapp.setStaus(LoanStatus.CREATED);
		
		return repository.save(custloanapp);
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
			c.setStaus(newstatus);
			return repository.save(c);
			
		}
		
	}

	@Override
	public CustomerLoanApplication update_loanapp_details(int custid, String custJson, MultipartFile pancard,
			MultipartFile adharcard, MultipartFile photo, MultipartFile signature) {
		Optional<CustomerLoanApplication> op= repository.findById(custid);
		if(op.isEmpty()) {
			throw new RuntimeException("Customer ID not Found!!!");
		}
		else {
			 CustomerLoanApplication custloanapp=null;
			     CustomerLoanApplication c=  op.get();
			     if(c.getCustomerId()==custid)
			     {
			    	 ObjectMapper mapper=new ObjectMapper();
			    	
			 	    AllPersonalDocuments apd=new AllPersonalDocuments();
			 	    
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
			 		} catch (IOException e) {
			 			// TODO Auto-generated catch block
			 			e.printStackTrace();
			 		}
			 		
			 		
			     }
			     custloanapp.setCustomerId(custid);
			     return repository.save(custloanapp);   
		}
		
	}

}
