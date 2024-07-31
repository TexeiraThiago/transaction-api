package com.thiago.transaction_api.services;

import com.thiago.transaction_api.domain.dto.TransactionDTO;
import com.thiago.transaction_api.domain.entities.Transaction;

import java.util.List;
import java.util.UUID;

public interface ITransactionService {

    Transaction save(TransactionDTO transactionDTO);
    List<Transaction> findAll();
    Transaction findById(UUID id);
    Transaction update(UUID id, TransactionDTO transactionDTO);
    void delete(UUID id);
}
