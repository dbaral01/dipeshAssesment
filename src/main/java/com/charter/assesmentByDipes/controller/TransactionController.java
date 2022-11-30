package com.charter.assesmentByDipes.controller;


import com.charter.assesmentByDipes.model.Transaction;
import com.charter.assesmentByDipes.service.CustomerServiceImpl;
import com.charter.assesmentByDipes.service.TransactionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer_transactions")
public class TransactionController {
    @Autowired
    TransactionImpl transactionImpl;

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransaction() {
        return ResponseEntity.ok(transactionImpl.findAllCustomerTransaction());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction) {
        transaction.setCustomer(customerService.getCustomerById(transaction.getCustomer().getId()));
        return ResponseEntity.ok(transactionImpl.saveTransaction(transaction));
    }

}
