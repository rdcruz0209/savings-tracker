package com.rdcruz.savingstracker.service;

import com.rdcruz.savingstracker.domain.entity.Transaction;
import com.rdcruz.savingstracker.domain.enums.TypeEnum;

import java.util.List;

public interface TransactionService {

    Transaction getTransactionByDescription(String description);
    List<Transaction> findAllTransaction();
    Transaction findById(String transactionId);
    Transaction saveTransaction(Transaction transaction);
    void deleteTransactionById(String transactionId);
    List<Transaction> findAllTransactionByType(TypeEnum type);
    Transaction createTransaction(Transaction transaction);
    Transaction updateTransaction(Transaction transaction, String id);
}
