package com.bank.transfer.controller;


import com.bank.transfer.aspects.AuditAspect;
import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.service.AccountTransferService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Tag(name = "main_methods")
@RestController
@RequestMapping("/account")

public class AccountRestController {
    private final AccountTransferService accountTransferService;
    private final AuditAspect auditAspect;

    @Autowired
    public AccountRestController(AccountTransferService accountTransferService, AuditAspect auditAspect) {
        this.accountTransferService = accountTransferService;
        this.auditAspect = auditAspect;
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
    public ResponseEntity<Void> addAccountTransfer(@RequestBody AccountTransfer accountTransfer) {
        accountTransferService.saveAccountTransfer(accountTransfer);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @PutMapping("/{id}")
    public AccountTransfer updateAccountTransfer(@RequestBody AccountTransfer accountTransfer, @PathVariable("id") long id) {
        return accountTransferService.updateAccountTransferById(accountTransfer, id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountTransfer(@PathVariable long id) {
        accountTransferService.deleteAccountTransfer(id);
        return ResponseEntity.noContent().build();
    }
}
