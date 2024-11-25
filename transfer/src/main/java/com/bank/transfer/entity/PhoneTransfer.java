package com.bank.transfer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "phone_transfer")
//@ToString
//@Setter
//@Getter
//@NoArgsConstructor
public class PhoneTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number")
    private Long phoneNumber;

    private BigDecimal amount;

    private String purpose;

    @Column(name = "account_details_id")
    private Long accountDetailsId;

    public PhoneTransfer() {
    }

    public PhoneTransfer(Long phoneNumber, BigDecimal amount,
                         String purpose, Long accountDetailsId) {
        this.phoneNumber = phoneNumber;
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

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        return "PhoneTransfer{" +
                "id=" + id +
                ", phoneNumber=" + phoneNumber +
                ", amount=" + amount +
                ", purpose='" + purpose + '\'' +
                ", accountDetailsId=" + accountDetailsId +
                '}';
    }
}
