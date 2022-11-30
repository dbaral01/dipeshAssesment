package com.charter.assesmentByDipes.service;

import com.charter.assesmentByDipes.model.Transaction;
import com.charter.assesmentByDipes.repository.TransactionRepository;
import com.charter.assesmentByDipes.helper.RewardUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAllCustomerTransaction() {
        return transactionRepository.findAll();
    }



    @Override
    public Transaction saveTransaction(Transaction transaction) {
        if (transaction.getTransactionDate() == null) {
            transaction.setTransactionDate(LocalDateTime.now());
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            LocalDateTime transactionDate = LocalDateTime.parse(String.valueOf(transaction.getTransactionDate()).replace("T", " "), formatter);
            transaction.setTransactionDate(transactionDate);
        }
        transaction.setRewardPerTransaction(RewardUtils.calculateRewardPoint(transaction.getAmount()));
        return transactionRepository.save(transaction);
    }

    @Override
    public Map<String, Long> getTotalRewardPointForCustomer(Long id) {
        Map<String, Long> totalReward = new HashMap<>();
        totalReward.put("customerId", id);
        totalReward.put("totalReward", transactionRepository.getTotalRewardPointForCustomer(id));

        return totalReward;
    }


    @Override
    public List<Object> getRewardPointPerMonth(Long id) throws SQLException {
        return transactionRepository.getMonthlyUserRewards(id);
    }
}
