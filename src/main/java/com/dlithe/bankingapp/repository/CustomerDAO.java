package com.dlithe.bankingapp.repository;

import com.dlithe.bankingapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,Integer> {


    @Query(value = "SELECT * FROM customer WHERE name=?1",nativeQuery = true)
    Customer findByName(String customerName);


    @Query(value = "SELECT * FROM customer WHERE id=?1 AND name=?2",nativeQuery = true)
    Customer findByIdAndName(int customerId, String customerName);
}
