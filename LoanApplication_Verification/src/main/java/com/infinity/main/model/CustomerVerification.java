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
public class CustomerVerification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int verificationId;
	@CreationTimestamp
	private java.sql.Date verificationDate;
	private String status;
	private String remarks;

}
