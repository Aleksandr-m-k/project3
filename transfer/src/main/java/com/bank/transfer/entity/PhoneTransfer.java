package com.bank.transfer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "phone_transfer", schema = "transfer")
@ToString
@Setter
@Getter
@NoArgsConstructor
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


    public PhoneTransfer(Long phoneNumber, BigDecimal amount,
                         String purpose, Long accountDetailsId) {
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.purpose = purpose;
        this.accountDetailsId = accountDetailsId;
    }
}
