package com.infinity.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinity.main.model.Enquiry;
@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{

	public Enquiry findByEnquiryStatus(Enum estatus);

}
