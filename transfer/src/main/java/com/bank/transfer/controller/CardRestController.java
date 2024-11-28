package com.bank.transfer.controller;

import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.service.CardTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Optional<CardTransfer> cardTransfer = cardTransferService.getCardTransferById(id);
        return new ResponseEntity<>(cardTransfer, HttpStatus.OK);
    }

    @GetMapping("/byCard/{number}")
    public ResponseEntity<CardTransfer> getCardTransferByNumber(@PathVariable Long number) {
        CardTransfer cardTransfer=cardTransferService.findTransferByCardNumber(number);
     return new ResponseEntity<>(cardTransfer,HttpStatus.OK);
        }

    @GetMapping("/")
    public ResponseEntity<List<CardTransfer>> getCardTransfer() {
        List<CardTransfer> cardTransfers = cardTransferService.allCardTransfer();

        if (cardTransfers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(cardTransfers, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Void> addNewCardTransfer(@RequestBody CardTransfer cardTransfer) {
        cardTransferService.saveOrUpdateCardTransfer(cardTransfer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/")
    public ResponseEntity<HttpStatus> updateCardTransfer(@RequestBody CardTransfer cardTransfer) {
        cardTransferService.saveOrUpdateCardTransfer(cardTransfer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCardTransfer(@PathVariable long id) {
        cardTransferService.deleteCardTransfer(id);
        return ResponseEntity.ok().build();
    }

}
