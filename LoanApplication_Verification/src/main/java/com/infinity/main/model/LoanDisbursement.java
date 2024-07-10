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
public class LoanDisbursement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int agreementId;
	private long loanNumber;
	@CreationTimestamp
	private java.sql.Date agreementDate;
	private double totalAmount;
	private String bankName;
	private long accountNo;
	private String IFSCcode;
	private String accountType;
	private double transferAmount;
	private String paymentStatus;
	private String amountDisburseDate;
	

}
