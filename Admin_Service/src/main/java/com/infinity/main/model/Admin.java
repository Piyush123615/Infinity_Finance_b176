package com.infinity.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	private String firstName;
	private String lastName;
    private String email;
    private String occupation;
    private float salary;
    private int age;
    
    @Enumerated(EnumType.STRING)
    private UserType userType;
    
    @Lob
    @Column(length = 999999999)
    private byte[] adminImage;
    
    private String username;
    private String password;
}
