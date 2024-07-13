package com.infinity.main.model;


import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enquiryID;
	
	@NotNull(message = "First name cannot be null")
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    @Min(value = 21, message = "Age should not be less than 21")
    @Max(value = 100, message = "Age should not be greater than 100")
    private int age;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Mobile number cannot be null")
    @Pattern(regexp = "^[7-9][0-9]{9}$", message = "Mobile number must be 10 digits starting with 7, 8, or 9")
    private String mobno;

    @NotNull(message = "PAN card number cannot be null")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "PAN card number should be valid")
    private String pancardno;

    @NotNull(message = "Aadhar card number cannot be null")
    @Pattern(regexp = "\\d{12}", message = "Aadhar card number must be 12 digits")
	private String adharcardno;
    
	 @NotEmpty(message = "Please enter your gender.")
	private String gender;
	@Enumerated(EnumType.STRING)
	private enquirystatus status;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private Cibil cibil;

}
