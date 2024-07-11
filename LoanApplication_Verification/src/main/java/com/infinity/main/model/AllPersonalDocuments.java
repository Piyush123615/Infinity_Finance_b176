package com.infinity.main.model;

import jakarta.persistence.Column;

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
public class AllPersonalDocuments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int documentId;
	@Column(length = 999999999)
	private byte[] pancard;
	@Column(length = 999999999)
	private byte[] adharcard;
	@Column(length = 999999999)
	private byte[] photo;
	@Column(length = 999999999)
	private byte[] sign;

}
