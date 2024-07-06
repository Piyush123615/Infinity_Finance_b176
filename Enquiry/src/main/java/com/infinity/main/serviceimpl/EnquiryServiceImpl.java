package com.infinity.main.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinity.main.model.Enquiry;
import com.infinity.main.model.enquirystatus;
import com.infinity.main.repository.EnquiryRepository;
import com.infinity.main.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	@Autowired
	EnquiryRepository enquiryRepository;

	@Override
	public Enquiry save_enq_data(Enquiry e) {
		
		Enquiry enq=enquiryRepository.save(e);
		return enq;
	}

	@Override
	public List<Enquiry> getAll_enqDetails() {
		
		List<Enquiry> enqlist = enquiryRepository.findAll();
		return enqlist;
	}

	@Override
	public List<Enquiry> get_enqDetailsbystatus(enquirystatus status) {
		
		List<Enquiry> enq=enquiryRepository.findAllByStatus(status);
		return enq;
	}

	@Override

	public Enquiry update_enq_byid(Enquiry en, int enquiryId) {
		
		Optional<Enquiry> enq =enquiryRepository.findById(enquiryId);
		
		if(enq.isPresent())
		{
			Enquiry e=enq.get();
			en.setEnquiryID(e.getEnquiryID());
			return enquiryRepository.save(en);
		}
		else
		{
			throw new RuntimeException("Id not found!!");
		}
	}

	public Enquiry update_enq_status(Enquiry en, int enquiryID, enquirystatus status) {
		     Optional<Enquiry> enq = enquiryRepository.findById(enquiryID);
		     if(enq.isPresent())
		     {
		    	 Enquiry e=enq.get();
		    	 en.setEnquiryID(e.getEnquiryID());
		    	 en.setStatus(status);
		    	 return enquiryRepository.save(en);
		     }
		     else
		     {
		    	 throw new RuntimeException("ID not Found!!!");
		     }
		
	}

	

	}

	
	
	


