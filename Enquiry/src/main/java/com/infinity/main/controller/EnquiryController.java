package com.infinity.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infinity.main.model.Cibil;
import com.infinity.main.model.Enquiry;
import com.infinity.main.model.enquirystatus;
import com.infinity.main.service.EnquiryService;

@RestController
public class EnquiryController {
	@Autowired
	EnquiryService enquiryService;
	
	@PostMapping("/create_enquiry")
	public ResponseEntity<Enquiry> save_enquiry(@RequestBody Enquiry e)
	{
		Enquiry en=enquiryService.save_enq_data(e);
		return new ResponseEntity<Enquiry>(en, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll_enquiry")
	public ResponseEntity<List<Enquiry>> getAll_enquiry()
	{
		List<Enquiry> enq=enquiryService.getAll_enqDetails();
		return new ResponseEntity<List<Enquiry>>(enq, HttpStatus.OK);
	}
	
	@GetMapping("/get_enquiry/{status}")
	public ResponseEntity<List<Enquiry>> get_enquirybystatus(@PathVariable enquirystatus status)
	{
		List<Enquiry> enq=enquiryService.get_enqDetailsbystatus(status);
		return new ResponseEntity<List<Enquiry>>(enq, HttpStatus.OK);
	}
	
	
	@PatchMapping("/update_enq_status/{enquiryID}/{status}")
	public ResponseEntity<Enquiry>update_status(@RequestBody Enquiry en,@PathVariable int enquiryID,@PathVariable enquirystatus status)
	{
		     Enquiry enq= enquiryService.update_enq_status(en,enquiryID,status);
		     return new ResponseEntity<Enquiry>(enq, HttpStatus.OK);
	}
	
	@PutMapping("/update_enquiry/{enquiryId}")
	public ResponseEntity<Enquiry> update_enquiry(@RequestBody Enquiry en, @PathVariable int enquiryId)	
	{
		Enquiry e=enquiryService.update_enq_byid(en,enquiryId);
		return new ResponseEntity<Enquiry>(e, HttpStatus.OK);
	}

	
	@PutMapping("/add_cibil/{enquiryId}")
	public ResponseEntity<Enquiry>addcibil(@PathVariable int enquiryId){
		
		Enquiry e=enquiryService.addCibil(enquiryId);
		
		return new ResponseEntity<Enquiry>(e,HttpStatus.OK);
		
	}
@GetMapping("/get_enq_byenq_cibilstatus/{estatus}/{cstatus}")
public ResponseEntity<List<Enquiry>> get_enq_bystatus(@PathVariable enquirystatus estatus,@PathVariable String cstatus)
{
	   List<Enquiry> e  =  enquiryService.get_enq_bystatus(estatus,cstatus);
	   return new ResponseEntity<List<Enquiry>>( e,HttpStatus.OK);
}
		
}
