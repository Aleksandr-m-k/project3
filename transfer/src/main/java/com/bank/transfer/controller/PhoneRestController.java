package com.bank.transfer.controller;

import com.bank.transfer.entity.PhoneTransfer;
import com.bank.transfer.service.PhoneTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/phone")
public class PhoneRestController {
    private final PhoneTransferService phoneTransferService;

    @Autowired
    public PhoneRestController(PhoneTransferService phoneTransferService) {
        this.phoneTransferService = phoneTransferService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PhoneTransfer>> getPhoneTransferById(@PathVariable Long id) {
        Optional<PhoneTransfer> phoneTransfer = phoneTransferService.getPhoneTransferById(id);
        return new ResponseEntity<>(phoneTransfer, HttpStatus.OK);
    }

    @GetMapping("/byPhone/{number}")
    public ResponseEntity<PhoneTransfer> getPhoneTransferByNumber(@PathVariable Long number) {
        PhoneTransfer PhoneTransfer=phoneTransferService.findTransferbyPhoneNumber(number);
        return new ResponseEntity<>(PhoneTransfer,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<PhoneTransfer>> getPhoneTransfer() {
        List<PhoneTransfer> phoneTransfers = phoneTransferService.allPhoneTransfer();

        if (phoneTransfers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(phoneTransfers, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Void> addNewPhoneTransfer(@RequestBody PhoneTransfer phoneTransfer) {
        phoneTransferService.saveOrUpdatePhoneTransfer(phoneTransfer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/")
    public ResponseEntity<HttpStatus> updatePhoneTransfer(@RequestBody PhoneTransfer phoneTransfer) {
        phoneTransferService.saveOrUpdatePhoneTransfer(phoneTransfer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoneTransfer(@PathVariable long id) {
        phoneTransferService.deletePhoneTransfer(id);
        return ResponseEntity.ok().build();
    }
}
