package com.charter.assesmentByDipes.service;

import com.charter.assesmentByDipes.model.Customer;


import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer saveCustomer(Customer customer);

}
