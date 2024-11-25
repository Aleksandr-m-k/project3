package com.bank.transfer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="account_transfer",  schema = "transfer")
public class AccountTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="account_number")
    private Long accountNumber;

    private BigDecimal amount;

    private String purpose;

    @Column(name="account_details_id")
    private Long accountDetailsId;

    public AccountTransfer() {
    }

    public AccountTransfer(Long accountNumber, BigDecimal amount,
                           String purpose, Long accountDetailsId) {
        this.accountNumber = accountNumber;
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

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
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
        return "AccountTransfer{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", amount=" + amount +
                ", purpose='" + purpose + '\'' +
                ", accountDetailsId=" + accountDetailsId +
                '}';
    }
}
