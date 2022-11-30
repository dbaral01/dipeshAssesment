package com.charter.assesmentByDipes.controller;


import com.charter.assesmentByDipes.model.Customer;
import com.charter.assesmentByDipes.service.CustomerService;
import com.charter.assesmentByDipes.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        System.out.print(customer.toString());
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @GetMapping("/totalrewards/{id}")
    public ResponseEntity<Map<String, Long>> totalRewardsForCustomer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(transactionService.getTotalRewardPointForCustomer(id));
    }

    @GetMapping("/rewardbyMonth/{id}")
    public ResponseEntity<List<Object>> rewardByUserReward(@PathVariable("id") Long id) throws SQLException {
        return ResponseEntity.ok(transactionService.getRewardPointPerMonth(id));
    }
}
