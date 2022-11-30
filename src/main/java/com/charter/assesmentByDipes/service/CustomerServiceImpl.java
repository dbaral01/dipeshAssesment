package com.charter.assesmentByDipes.service;

import com.charter.assesmentByDipes.model.Customer;
import com.charter.assesmentByDipes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setJoinedDate(LocalDateTime.now());
        return customerRepository.save(customer);
    }


    public Customer getCustomerById(Long id) {
        return customerRepository.getById(id);
    }



}
