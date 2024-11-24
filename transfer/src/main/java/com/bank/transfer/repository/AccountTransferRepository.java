package com.bank.transfer.repository;

import com.bank.transfer.entity.AccountTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AccountTransferRepository extends JpaRepository<AccountTransfer, Long> {
//        @Override
//        AccountTransfer findByAccountNumber(Long accountNumber);
//        @Override
//        List<AccountTransfer> findAll();

}
