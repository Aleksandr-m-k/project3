package com.bank.transfer.controller;

import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.service.CardTransferService;
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

@RestController
@RequestMapping("/card")
public class CardRestController {
    private final CardTransferService cardTransferService;

    @Autowired
    public CardRestController(CardTransferService cardTransferService) {
        this.cardTransferService = cardTransferService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CardTransfer>> getCardTransferById(@PathVariable Long id) {
        final Optional<CardTransfer> cardTransfer = cardTransferService.getCardTransferById(id);
        return new ResponseEntity<>(cardTransfer, HttpStatus.OK);
    }

    @GetMapping("/byCard/{number}")
    public ResponseEntity<CardTransfer> getCardTransferByNumber(@PathVariable Long number) {
        final CardTransfer cardTransfer = cardTransferService.findTransferByCardNumber(number);
        return new ResponseEntity<>(cardTransfer, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CardTransfer>> getCardTransfer() {
        final List<CardTransfer> cardTransfers = cardTransferService.allCardTransfer();

        if (cardTransfers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(cardTransfers, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Void> addNewCardTransfer(@RequestBody CardTransfer cardTransfer) {
        cardTransferService.saveCardTransfer(cardTransfer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public CardTransfer updateCardTransfer(@RequestBody CardTransfer cardTransfer,
                                           @PathVariable("id") long id) {
        return cardTransferService.updateCardTransferById(cardTransfer, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCardTransfer(@PathVariable long id) {
        cardTransferService.deleteCardTransfer(id);
        return ResponseEntity.ok().build();
    }

}
