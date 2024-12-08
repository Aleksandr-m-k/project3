package com.bank.transfer.service;

import com.bank.transfer.entity.CardTransfer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CardTransferService {
    CardTransfer findTransferByCardNumber(Long cardNumber);

    Optional<CardTransfer> getCardTransferById(Long id);

    List<CardTransfer> allCardTransfer();

    CardTransfer saveCardTransfer(CardTransfer cardTransfer);

    CardTransfer updateCardTransferById(CardTransfer cardTransfer, long id);

    void deleteCardTransfer(Long id);
}
