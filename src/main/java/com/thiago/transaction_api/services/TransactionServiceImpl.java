package com.thiago.transaction_api.services;

import com.thiago.transaction_api.domain.dto.TransactionDTO;
import com.thiago.transaction_api.domain.entities.Transaction;
import com.thiago.transaction_api.repositories.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements ITransactionService {
    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transaction save(TransactionDTO transactionDTO) {
        Transaction transaction = Transaction.builder().build();
        BeanUtils.copyProperties(transactionDTO, transaction);
        return repository.save(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return repository.findAll();
    }

    @Override
    public Transaction findById(UUID id) {
        Optional<Transaction> transactionOptional = repository.findById(id);
        if (transactionOptional.isEmpty()) {
            throw new NoSuchElementException("There is no such id in data base");
        }
        return transactionOptional.get();
    }

    @Override
    public Transaction update(UUID id, TransactionDTO transactionDTO) {
        Optional<Transaction> byId = repository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Transaction Not found");
        }
        BeanUtils.copyProperties(transactionDTO, byId.get());
        return repository.save(byId.get());
    }

    @Override
    public void delete(UUID id) {
        Optional<Transaction> byId = repository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Transaction Not found");
        }
        repository.delete(byId.get());
    }
}
