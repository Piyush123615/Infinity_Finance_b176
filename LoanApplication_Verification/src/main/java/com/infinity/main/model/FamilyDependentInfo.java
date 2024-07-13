package com.infinity.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamilyDependentInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dependentinfoId;
	
	@Min(value = 1, message = "Number of family members must be at least 1")
	private int noofFamilyMember;
	
	@Min(value = 0, message = "Number of children cannot be negative")
	private int noofChild;
	
	@NotBlank(message = "Marital status is mandatory")
	private String maritalstatus;
	
	@NotBlank(message = "Dependent member information is mandatory")
	private String dependentmember;
	
	//@NotNull(message = "Family Income cannot be null")
	//@NotEmpty(message = "Please enter your Family Income")
	private double  familyIncome;

}
