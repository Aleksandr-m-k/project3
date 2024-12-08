package com.bank.transfer.service;

import com.bank.transfer.entity.AccountTransfer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountTransferService {
    AccountTransfer findTransferByAccountNumber(Long accountNumber);

    Optional<AccountTransfer> getAccountTransferById(Long id);

    List<AccountTransfer> allAccountTransfer();

    AccountTransfer saveAccountTransfer(AccountTransfer accountTransfer);

    AccountTransfer updateAccountTransferById(AccountTransfer accountTransfer, long id);

    void deleteAccountTransfer(Long id);
}
