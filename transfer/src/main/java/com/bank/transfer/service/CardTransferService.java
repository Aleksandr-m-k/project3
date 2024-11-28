package com.bank.transfer.service;

import com.bank.transfer.entity.CardTransfer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CardTransferService {
    CardTransfer findTransferByCardNumber(Long CardNumber);
    Optional<CardTransfer> getCardTransferById(Long id);

    List<CardTransfer> allCardTransfer();

    CardTransfer saveOrUpdateCardTransfer(CardTransfer cardTransfer);

    void deleteCardTransfer(Long id);
}
