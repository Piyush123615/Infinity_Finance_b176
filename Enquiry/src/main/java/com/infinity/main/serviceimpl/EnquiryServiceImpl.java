package com.infinity.main.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cjc.main.exception.EnquiryIdNotFoundException;
import com.infinity.main.model.Cibil;

import com.infinity.main.model.Enquiry;
import com.infinity.main.model.enquirystatus;
import com.infinity.main.repository.EnquiryRepository;
import com.infinity.main.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	@Autowired
	EnquiryRepository enquiryRepository;
	
	@Autowired
	JavaMailSender sender;
	
	@Value("${spring.mail.username}")
    private String fromMail;

	@Override
	public Enquiry save_enq_data(Enquiry e) 
	{
		e.setStatus(enquirystatus.IN_PROGRESS);
		return enquiryRepository.save(e);
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
			throw new EnquiryIdNotFoundException("EnquiryID is not Available!!!");
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
		    	 throw new EnquiryIdNotFoundException("EnquiryID is not Available!!!");
		     }
		
	}

	@Override
	public Enquiry addCibil(int enquiryId) {
		
		Optional<Enquiry> e=enquiryRepository.findById(enquiryId);
		
		if(e.isEmpty())
		{
		
			throw new EnquiryIdNotFoundException("EnquiryID is not Available!!!");
		
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
				eq.setStatus(enquirystatus.REJECTED);
			}
			
			else if(cibilscore>500 && cibilscore<=750)
				
			{
				
				c.setCibilstatus("Good");
				eq.setStatus(enquirystatus.APPROVED);
			}
			
			else
			{
				c.setCibilstatus("Excellent");
				eq.setStatus(enquirystatus.APPROVED);
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

	@Override
	public void send_Email(int enquiryId) {

		Optional<Enquiry> e = enquiryRepository.findById(enquiryId);
		SimpleMailMessage mail=new SimpleMailMessage();
		
		if(e.isEmpty())
		{
			throw new EnquiryIdNotFoundException("Enquiry not found on given enq status!!");
		}
		else
		{
			Enquiry enq=e.get();
			
			if(enq.getCibil().getCibilstatus().equalsIgnoreCase("Good") || enq.getCibil().getCibilstatus().equalsIgnoreCase("Excellent"))
			{
				mail.setFrom(fromMail);
				mail.setTo(enq.getEmail());
				mail.setSubject("Loan Enquiry Response Mail");
				mail.setText("Dear "+enq.getFirstName()+" "+enq.getLastName()+"\n"
						+ "Congratulations! Your loan application has been approved.\n"
						+ "Please review the terms and conditions, and contact us for any clarification.\n"
						+ "We Appreciate your trust in us.\n\n"
						+ "Enquiry Details:\n1.Enquiry Id: "+enq.getEnquiryID()+"\n"
								+ "2.Pan Card Number: "+enq.getPancardno()+"\n"
										+ "3.Aadhar Card Number: "+enq.getAdharcardno()+"\n"
												+ "4.Cibil Score: "+enq.getCibil().getCibilscore()
												+ "\n\nBest Regards \nInfinity Finance");
				sender.send(mail);
			}
			else
			{
				mail.setFrom(fromMail);
				mail.setTo(enq.getEmail());
				mail.setSubject("Loan Enquiry Response Mail");
				mail.setText("Dear "+enq.getFirstName()+" "+enq.getLastName()+"\n"
						+ "We regret to inform you that your loan application has been declined.\n"
						+ "Please review our eligibility criteria and consider reapplying in the future.\n"
						+ "For further assistance contact our support team.\n\n"
						+ "Enquiry Details:\n 1.Enquiry Id: "+enq.getEnquiryID()+"\n"
						+ "2.Pan Card Number: "+enq.getPancardno()+"\n"
								+ "3.Aadhar Card Number: "+enq.getAdharcardno()+"\n"
										+ "4.Cibil Score: "+enq.getCibil().getCibilscore()
										+ "\n\nBest Regards \nInfinity Finance");
				sender.send(mail);
			}
			
		}
	}

	

}

	
	
	


