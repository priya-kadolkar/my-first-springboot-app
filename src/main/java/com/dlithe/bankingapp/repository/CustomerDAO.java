package com.dlithe.bankingapp.repository;

import com.dlithe.bankingapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,Integer> {

}
