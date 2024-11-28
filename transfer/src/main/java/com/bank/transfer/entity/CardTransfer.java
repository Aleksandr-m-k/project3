package com.bank.transfer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "card_transfer",  schema = "transfer")
@ToString
@Setter
@Getter
@NoArgsConstructor
public class CardTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="card_number")
    private Long cardNumber;

    private BigDecimal amount;

    private String purpose;

    @Column(name="account_details_id")
    private Long accountDetailsId;


    public CardTransfer(Long cardNumber, BigDecimal amount, String purpose, Long accountDetailsId) {
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.purpose = purpose;
        this.accountDetailsId = accountDetailsId;
    }

}
