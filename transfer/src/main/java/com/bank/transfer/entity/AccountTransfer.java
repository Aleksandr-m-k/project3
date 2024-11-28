package com.bank.transfer.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account_transfer", schema = "transfer")
@ToString
@Setter
@Getter
@NoArgsConstructor
//@Builder
public class AccountTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number")
    private Long accountNumber;

    private BigDecimal amount;

    private String purpose;

    @Column(name = "account_details_id")
    private Long accountDetailsId;

    public AccountTransfer(Long accountNumber, BigDecimal amount,
                           String purpose, Long accountDetailsId) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.purpose = purpose;
        this.accountDetailsId = accountDetailsId;
    }
}
