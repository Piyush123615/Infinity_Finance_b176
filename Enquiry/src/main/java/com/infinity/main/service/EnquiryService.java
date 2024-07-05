package com.infinity.main.service;

import java.util.List;

import com.infinity.main.model.Enquiry;
import com.infinity.main.model.enquirystatus;

public interface EnquiryService {

	public Enquiry save_enq_data(Enquiry e);

	public List<Enquiry> getAll_enqDetails();

	public List<Enquiry> get_enqDetailsbystatus(enquirystatus status);

	

}
