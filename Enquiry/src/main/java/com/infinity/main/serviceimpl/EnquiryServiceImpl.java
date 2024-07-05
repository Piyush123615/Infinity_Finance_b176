package com.infinity.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinity.main.model.Enquiry;
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
	public Enquiry get_enqDetailsbyestatus(Enum estatus) {
		        Enquiry e   = enquiryRepository.findByEnquiryStatus(estatus);
		return e;
	}
	
	

}
