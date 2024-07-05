package com.infinity.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinity.main.model.Enquiry;
import com.infinity.main.model.enquirystatus;
@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{

	public List<Enquiry> findAllByStatus(enquirystatus status);

	

}
