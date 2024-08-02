package com.infinity.main.service;

import java.util.List;

import com.infinity.main.model.Cibil;
import com.infinity.main.model.Enquiry;
import com.infinity.main.model.enquirystatus;

public interface EnquiryService {
	              //saveEnqyData

	public Enquiry save_enq_data(Enquiry e);

	public List<Enquiry> getAll_enqDetails();

	public List<Enquiry> get_enqDetailsbystatus(enquirystatus status);


	public Enquiry update_enq_byid(Enquiry en, int enquiryId);


	public Enquiry update_enq_status(int enquiryID, enquirystatus status);

	public Enquiry addCibil(int enquiryId);

	public List<Enquiry> get_enq_bystatus(enquirystatus estatus, String cstatus);

	public void send_Email(int enquiryId);


	

}
