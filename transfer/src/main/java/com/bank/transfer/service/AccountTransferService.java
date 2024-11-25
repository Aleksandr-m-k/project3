package com.bank.transfer.service;

import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.repository.AccountTransferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountTransferService{
    AccountTransfer findTransferByAccountTransfer (Long AccountNumber);
    AccountTransfer getTransferById(long id);
    List<AccountTransfer> allAccountTransfer();
    void saveAccountTransfer(AccountTransfer accountTransfer);
    AccountTransfer update (AccountTransfer accountTransfer, long accountNumber);
    void deleteAccountTransfer (Long id);
    }
