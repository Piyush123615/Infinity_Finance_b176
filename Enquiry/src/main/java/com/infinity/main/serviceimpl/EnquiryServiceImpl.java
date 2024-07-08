package com.infinity.main.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinity.main.model.Cibil;
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

	@Override
	public Enquiry addCibil(int enquiryId) {
		
		Optional<Enquiry> e=enquiryRepository.findById(enquiryId);
		
		if(e.isEmpty())
		{
		
			throw new RuntimeException("Id Not Found");
		
		}
			
		else
			
		{
			Enquiry eq=e.get();
			Random random=new Random();
			int cibilscore=300+random.nextInt(601);
			Cibil c=new Cibil();
			c.setCibilscore(cibilscore);
			
			if(cibilscore<=550)
			{
				c.setCibilstatus("Poor");
			}
			
			else if(cibilscore>500 && cibilscore<=750)
				
			{
				
				c.setCibilstatus("Good");
			}
			
			else
			{
				c.setCibilstatus("Excellent");
			}
			
			eq.setCibil(c);
			
			return enquiryRepository.save(eq);
		}		
	}

	@Override
	public List<Enquiry> get_enq_bystatus(enquirystatus estatus, String cstatus) {
		
		 List<Enquiry> ll = enquiryRepository.findAllByStatus(estatus);
		 List<Enquiry> nlist=new ArrayList<Enquiry>();
		 
		 if(ll.isEmpty())
		 {
			 throw new RuntimeException("Enquiry not found on given enq status!!");
		 }
		 else
		 {
			 for (Enquiry enq : ll) {
				 
				 String st=enq.getCibil().getCibilstatus();
				
				 if(st.equalsIgnoreCase(cstatus))
				 {
					 nlist.add(enq);
				 }
			}
		 }
		return nlist;
	}

	

}

	
	
	


