package com.infinity.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinity.main.model.CustomerLoanApplication;

public interface CustomerRepository extends JpaRepository<CustomerLoanApplication, Integer> {

}
