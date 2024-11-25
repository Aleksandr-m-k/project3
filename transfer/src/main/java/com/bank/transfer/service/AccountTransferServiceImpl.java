package com.bank.transfer.service;

import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.repository.AccountTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountTransferServiceImpl implements AccountTransferService {
    private AccountTransferRepository accountTransferRepository;

    @Autowired
    public AccountTransferServiceImpl(AccountTransferRepository accountTransferRepository) {
        this.accountTransferRepository = accountTransferRepository;
    }


    @Transactional
    public AccountTransfer findTransferByAccountTransfer(Long accountNumber) {
        AccountTransfer accountTransfer = accountTransferRepository.findByAccountNumber(accountNumber);
        return accountTransfer;
    }

    @Override
    @Transactional
    public List<AccountTransfer> allAccountTransfer() {
        List<AccountTransfer> accountTransfers = accountTransferRepository.findAll();
        return accountTransfers;
    }

    @Override
    public void saveAccountTransfer(AccountTransfer accountTransfer) {
        accountTransferRepository.save(accountTransfer);
    }

    @Override
    public AccountTransfer getTransferById(long accountNumber) {
        AccountTransfer accountTransfer= accountTransferRepository.findByAccountNumber(accountNumber);
        return accountTransfer;
    }

    @Override
    public AccountTransfer update (AccountTransfer updateAccountTransfer, long accountNumber) {
        AccountTransfer accountTransfer = getTransferById(accountNumber);
        accountTransfer.setAccountNumber(updateAccountTransfer.getAccountNumber());
        accountTransfer.setAmount(updateAccountTransfer.getAmount());
        accountTransfer.setPurpose(updateAccountTransfer.getPurpose());
        accountTransfer.setAccountDetailsId(updateAccountTransfer.getAccountDetailsId());
        return accountTransfer;
    }

    @Override
    public void deleteAccountTransfer (Long id){
        accountTransferRepository.deleteById(id);
    }
}
