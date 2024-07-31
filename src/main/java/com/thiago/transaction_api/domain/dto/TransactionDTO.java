package com.thiago.transaction_api.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDTO(
        BigDecimal total,
        LocalDateTime createdAt,
        String cardNumber,
        String ccv,
        String owner,
        String cpf
){

}
