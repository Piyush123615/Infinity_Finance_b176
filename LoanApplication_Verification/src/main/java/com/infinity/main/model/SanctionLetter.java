package com.infinity.main.model;

import org.hibernate.annotations.CreationTimestamp;

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
public class SanctionLetter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sanctionId;
	@CreationTimestamp
	private java.sql.Date sanctionDate;
	private String applicantName;
	private double contactDetails;
	private double marketPrice;
	private double loanAmountSanctioned;
	private String interestType;
	private float rateOfInterest;
	private int loanTenureInMonth;
	private double monthlyEMIAmount;
	private String modeOfPayment;
	private String remarks;
	private String termcondition;
	//enum
	private String staus;

}
