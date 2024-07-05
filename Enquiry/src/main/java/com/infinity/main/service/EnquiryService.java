package com.infinity.main.service;

import java.util.List;

import com.infinity.main.model.Enquiry;

public interface EnquiryService {

	public Enquiry save_enq_data(Enquiry e);

	public List<Enquiry> getAll_enqDetails();

	public Enquiry get_enqDetailsbyestatus(Enum estatus);

}
