package com.rdcruz.savingstracker.service.impl;

import com.rdcruz.savingstracker.domain.entity.Transaction;
import com.rdcruz.savingstracker.domain.enums.TypeEnum;
import com.rdcruz.savingstracker.domain.repository.TransactionRepository;
import com.rdcruz.savingstracker.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public Transaction getTransactionByDescription(String description) {
        return transactionRepository.getCreditsByDescription(description);
    }

    @Override
    public List<Transaction> findAllTransaction() {
        return transactionRepository.findAllTransaction();
    }

    @Override
    public Transaction findById(String transactionId) {
        Optional<Transaction> transactionOpt = transactionRepository.findById(transactionId);
        return transactionOpt.orElse(null);
    }

    public Transaction saveTransaction(Transaction transaction) {
        if (Objects.isNull(transaction.getTransactionDate())) {
            transaction.setTransactionDate(LocalDateTime.from(Instant.now()));
        }
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransactionById(String transactionId) {
        transactionRepository.deleteById(transactionId);
    }

    @Override
    public List<Transaction> findAllTransactionByType(TypeEnum type) {
        return transactionRepository.findAllTransactionByType(type);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        if (Objects.isNull(transaction.getTransactionDate())) {
            transaction.setTransactionDate(LocalDateTime.from(Instant.now()));
        }
        return transactionRepository.save(transaction);
    }

    @Override
    @Transactional
    public Transaction updateTransaction(Transaction transaction, String id) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction object is null");
        }
        Transaction transactionToBeUpdated = transactionRepository.findById(id)
                                                                  .orElseThrow(() -> new NoSuchElementException("No transaction found with id: " + id));
        updateIfNotNull(transaction.getAmount(), transactionToBeUpdated::setAmount);
        updateIfNotNull(transaction.getType(), transactionToBeUpdated::setType);
        updateIfNotNull(transaction.getDescription(), transactionToBeUpdated::setDescription);
        updateIfNotNull(transaction.getUser(), transactionToBeUpdated::setUser);

        return transactionRepository.save(transactionToBeUpdated);
    }

    private <T> void updateIfNotNull(T newValue, Consumer<T> setter) {
        if (newValue != null) {
            setter.accept(newValue);
        }
    }


}
