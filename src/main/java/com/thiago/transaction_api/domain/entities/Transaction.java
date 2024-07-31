package com.thiago.transaction_api.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID transactionId;
    private BigDecimal total;
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private String cardNumber;
    @Column(nullable = false)
    private String ccv;
    private String owner;
    @Column(nullable = false)
    private String cpf;
}
