package com.bank.transfer.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


public class AccountTransferDTO {
    private Long accountNumber;

    private BigDecimal amount;

    private String purpose;

    private Long accountDetailsId;

    public AccountTransferDTO(Long accountNumber,
                              BigDecimal amount, String purpose, Long accountDetailsId) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.purpose = purpose;
        this.accountDetailsId = accountDetailsId;
    }

//    public Long getAccountNumber() {
//        return accountNumber;
//    }
//
//    public void setAccountNumber(Long accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    public BigDecimal getAmount() {
//        return amount;
//    }
//
//    public void setAmount(BigDecimal amount) {
//        this.amount = amount;
//    }
//
//    public String getPurpose() {
//        return purpose;
//    }
//
//    public void setPurpose(String purpose) {
//        this.purpose = purpose;
//    }
//
//    public Long getAccountDetailsId() {
//        return accountDetailsId;
//    }
//
//    public void setAccountDetailsId(Long accountDetailsId) {
//        this.accountDetailsId = accountDetailsId;
//    }

    @Override
    public String toString() {
        return "AccountTransferDTO{" +
                "accountNumber=" + accountNumber +
                ", amount=" + amount +
                ", purpose='" + purpose + '\'' +
                ", accountDetailsId=" + accountDetailsId +
                '}';
    }

}
