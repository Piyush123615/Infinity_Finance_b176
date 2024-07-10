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
public class Ledger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ledgerId;
	@CreationTimestamp
	private java.sql.Date ledgerCreateDate;
	private double totalLoanAmount;;
	private double  paybleAmountWithIntrest;
	private int tenure;
	private double monthlyEMI;
	private double amountPayTillDate;
	private double remainingAmount;
	private String nextEMIDateStart;
	private String nextEMIDateEnd;
	private int defaulterCount;
	private String previousEMIStatus;
	private String currentMonthEmiStatus;
	private String loanEndDate;
	private String loanstatus;

}
