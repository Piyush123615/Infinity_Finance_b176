package com.infinity.main.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private long mobno;
	private String pancardno;
	private String adharcardno;
	private String gender;
	@Enumerated(EnumType.STRING)
	private enquirystatus status;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private Cibil cibil;

}
