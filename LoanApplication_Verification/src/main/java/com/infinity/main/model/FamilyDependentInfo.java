package com.infinity.main.model;

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
public class FamilyDependentInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dependentinfoId;
	private int noofFamilyMember;
	private int noofChild;
	private String maritalstatus;
	private String dependentmember;
	private double  familyIncome;

}
