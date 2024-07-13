package com.infinity.main.model;

import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
	
	@NotBlank(message="Customer name can not be empty")
    @Size(min = 2, max = 100 ,message="Customer name lenghth must Min= 2 and Max=100 letters")
	private String customerName;
	
	//@Past(message="Ensures that the date is in the past")
	private String customerDOB;
	
	@Min(value = 21, message = "Age should not be less than 21")
    @Max(value = 60, message = "Age should not be greater than 60")
	private int customerAge;
	
	@Min(value= 6, message="Minimum Required Tenure should be 6 Months")
	@Max(value = 120,message="Maximum Required Tenure should be 120 Months")
	private int requiredTenure;
	
	@NotEmpty(message = "Please enter your gender.")
	private String gender;
	 
	@NotNull(message = "Email cannot be null")
	@Email(message = "Email should be valid")
	private String email;
	
    @NotNull(message = "Mobile number cannot be null")
    @Pattern(regexp = "^[7-9][0-9]{9}$", message = "Mobile number must be 10 digits starting with 7, 8, or 9")
	private String mobno;
    
	private double downpayment;
	private double loanrequired;
	@Enumerated(EnumType.STRING)
	private LoanStatus status;
	@OneToOne(cascade = CascadeType.ALL)
	private AllPersonalDocuments allpersonaldocs;
	@OneToOne(cascade = CascadeType.ALL)
	private FamilyDependentInfo familydependentinfo;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress custaddr;
	//@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	//private CibilScore cs;
	@OneToOne(cascade = CascadeType.ALL)
	private AccountDetails  acdetails;
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails guarantordetails;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private LoanDisbursement loandisbursement;
	@OneToMany(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private Set<Ledger> ledger;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private SanctionLetter sanctionletter;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)	
	private CustomerVerification custverification;
	

}
