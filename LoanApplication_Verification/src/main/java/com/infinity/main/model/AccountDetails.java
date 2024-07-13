package com.infinity.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountDetailsId;
	@NotBlank(message = "Account type is mandatory")
	private String accountType;
	
	@Min(value=500,message ="Account balance must be 500")
	private double accountBalance;
	@NotBlank(message = "Account holder name is mandatory")
    @Size(min = 2, max = 100, message = "Account holder name must be between 2 and 100 characters")	
	private String accountHolderName;
    @NotBlank(message = "Account status is mandatory")
    private String accountStatus;
    @Min(value = 10, message = "Account number must be positive and non-zero")
    private long accountNumber;

}
