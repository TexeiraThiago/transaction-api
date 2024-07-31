package com.thiago.transaction_api.controllers;

import com.thiago.transaction_api.domain.dto.TransactionDTO;
import com.thiago.transaction_api.domain.entities.Transaction;
import com.thiago.transaction_api.services.TransactionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionServiceImpl transactionService;

    public TransactionController(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> save(@RequestBody TransactionDTO transactionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.save(transactionDTO));
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable UUID id, @RequestBody TransactionDTO transactionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.update(id,transactionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        transactionService.delete(id);
        return  ResponseEntity.status(HttpStatus.OK).body("Transaction deleted successfully");
    }
}

