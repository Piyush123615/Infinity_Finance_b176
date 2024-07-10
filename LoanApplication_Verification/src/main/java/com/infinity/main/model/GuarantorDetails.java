package com.infinity.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuarantorDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int guarantorId;
	private String guarantorName;
	private String guarantorDOB;
	private String guarantorRelationWithCustomer;
	private String guarantorMobNo;

	private String guarantorAdharNo;
	private String guarantorMortgageDetails;
	private String guarantorJobDetails;
	private String guarantorAddress;

}
