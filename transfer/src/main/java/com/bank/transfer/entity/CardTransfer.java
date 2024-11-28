package com.bank.transfer.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "card_transfer",  schema = "transfer")
//@ToString
//@Setter
//@Getter
//@NoArgsConstructor
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

    public CardTransfer() {
    }

    public CardTransfer(Long cardNumber, BigDecimal amount, String purpose, Long accountDetailsId) {
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.purpose = purpose;
        this.accountDetailsId = accountDetailsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Long getAccountDetailsId() {
        return accountDetailsId;
    }

    public void setAccountDetailsId(Long accountDetailsId) {
        this.accountDetailsId = accountDetailsId;
    }

    @Override
    public String toString() {
        return "CardTransfer{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", amount=" + amount +
                ", purpose='" + purpose + '\'' +
                ", accountDetailsId=" + accountDetailsId +
                '}';
    }
}
