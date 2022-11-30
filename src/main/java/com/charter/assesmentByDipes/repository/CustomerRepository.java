package com.charter.assesmentByDipes.repository;

import com.charter.assesmentByDipes.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
