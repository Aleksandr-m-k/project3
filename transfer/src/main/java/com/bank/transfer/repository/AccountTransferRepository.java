package com.bank.transfer.repository;

import com.bank.transfer.entity.AccountTransfer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountTransferRepository extends JpaRepository<AccountTransfer, Long> {
        AccountTransfer findByAccountNumber(Long accountNumber);


}
