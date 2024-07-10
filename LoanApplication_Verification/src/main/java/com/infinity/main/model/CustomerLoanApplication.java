package com.infinity.main.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoanApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String customerName;
	private String customerDOB;
	private int customerAge;
	private int requiredTenure;
	private String gender;
	private String email;
	private String mobno;
	private double downpayment;
	private double loanrequired;
	@Enumerated(EnumType.STRING)
	private LoanStatus staus;
	@OneToOne(cascade = CascadeType.ALL)
	private AllPersonalDocuments apd;
	@OneToOne(cascade = CascadeType.ALL)
	private FamilyDependentInfo fdi;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress ca;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private CibilScore cs;
	@OneToOne(cascade = CascadeType.ALL)
	private AccountDetails  ad;
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails gd;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private LoanDisbursement ld;
	@OneToMany(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private Ledger ledger;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private SanctionLetter sl;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)	
	private CustomerVerification cv;
	

}
