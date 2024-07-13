package com.infinity.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
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
	@NotBlank(message = "Guarantor name cannot be blank")
	private String guarantorName;
	
	//@NotNull(message = "Guarantor DOB cannot be null")
   // @Past(message = "Guarantor DOB must be a past date")
	private String guarantorDOB;
	
    @NotBlank(message = "Guarantor relation with customer cannot be blank")	
	private String guarantorRelationWithCustomer;
    
    @NotBlank(message = "Guarantor mobile number cannot be blank")
    @Pattern(regexp = "^[7-9][0-9]{9}$", message = "Guarantor Mobile number must be 10 digits starting with 7, 8, or 9")
	private String guarantorMobNo;
    
    @NotBlank(message = "Guarantor Aadhar number cannot be blank")
    @Pattern(regexp = "^\\d{12}$", message = "Guarantor Aadhar number must be 12 digits")
	private String guarantorAdharNo;
    
    @NotBlank(message = "Guarantor mortgage details cannot be blank")
	private String guarantorMortgageDetails;
    
    @NotBlank(message = "Guarantor job details cannot be blank")
	private String guarantorJobDetails;
    
    @NotBlank(message = "Guarantor address cannot be blank")
	private String guarantorAddress;

}
