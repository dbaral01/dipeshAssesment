package com.charter.assesmentByDipes.service;

import com.charter.assesmentByDipes.model.Transaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TransactionService {
    List<Transaction> findAllCustomerTransaction();

    Transaction saveTransaction(Transaction transaction);


    Map<String, Long> getTotalRewardPointForCustomer(Long id);
    List<Object>getRewardPointPerMonth(Long id) throws SQLException;
}
