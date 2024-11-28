package com.bank.transfer.controller;


import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.service.AccountTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountRestController {
    private final AccountTransferService accountTransferService;

    @Autowired
    public AccountRestController(AccountTransferService accountTransferService) {
        this.accountTransferService = accountTransferService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<AccountTransfer>> getAccountTransferById(@PathVariable Long id) {
        Optional<AccountTransfer> accountTransfer = accountTransferService.getAccountTransferById(id);
        return new ResponseEntity<>(accountTransfer, HttpStatus.OK);
    }

    @GetMapping("/byNumber/{number}")
    public ResponseEntity<AccountTransfer> getAccountTransferByNumber(@PathVariable Long number) {
        AccountTransfer accountTransfer = accountTransferService.findTransferByAccountNumber(number);
            return new ResponseEntity<>(accountTransfer, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<AccountTransfer>> getAccountTransfer() {
        List<AccountTransfer> accountTransfers = accountTransferService.allAccountTransfer();

        if (accountTransfers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(accountTransfers, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Void> addNewAccountTransfer(@RequestBody AccountTransfer accountTransfer) {
        accountTransferService.saveOrUpdateAccountTransfer(accountTransfer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/")
    public ResponseEntity<HttpStatus> updateAccountTransfer(@RequestBody AccountTransfer accountTransfer) {
        accountTransferService.saveOrUpdateAccountTransfer(accountTransfer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountTransfer(@PathVariable long id) {
        accountTransferService.deleteAccountTransfer(id);
        return ResponseEntity.ok().build();
    }
}
