package com.infinity.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinity.main.model.CustomerLoanApplication;
import com.infinity.main.model.LoanStatus;

public interface CustomerRepository extends JpaRepository<CustomerLoanApplication, Integer> {

	public CustomerLoanApplication findByCustomerId(int customerId);

	public CustomerLoanApplication findByStatus(LoanStatus status);

}
