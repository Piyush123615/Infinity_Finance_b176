package com.infinity.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	
	@NotBlank(message="Area name can not be empty")
    @Size(min = 2, max = 100 ,message="Area name lenghth must Min= 2 and Max=100 letters")
	private String areaName;
	
	@NotBlank(message="City name can not be empty")
    @Size(min = 2, max = 100 ,message="City name lenghth must Min= 2 and Max=100 letters")
	private String cityName;
	
	//@Pattern(regexp = "\\d{6}", message = "Pincode must be exactly 6 digits")
	private int pincode;
	
	@NotBlank(message="State name can not be empty")
    @Size(min = 2, max = 100 ,message="State name lenghth must Min= 2 and Max=100 letters")
	private String state;
	

}
