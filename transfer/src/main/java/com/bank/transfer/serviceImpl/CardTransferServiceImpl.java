package com.bank.transfer.serviceImpl;

import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.repository.CardTransferRepository;
import com.bank.transfer.service.CardTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CardTransferServiceImpl implements CardTransferService {
    private final CardTransferRepository cardTransferRepository;

    @Autowired
    public CardTransferServiceImpl(CardTransferRepository cardTransferRepository) {
        this.cardTransferRepository = cardTransferRepository;
    }

    @Override
    @Transactional
    public Optional<CardTransfer> getCardTransferById(Long id) {
        return cardTransferRepository.findById(id);
    }

    @Override
    @Transactional
    public CardTransfer findTransferByCardNumber(Long cardNumber) {
        return cardTransferRepository.findByCardNumber(cardNumber);
    }

    @Override
    @Transactional
    public List<CardTransfer> allCardTransfer() {
        return cardTransferRepository.findAll();
    }

    @Override
    @Transactional
    public CardTransfer saveCardTransfer(CardTransfer cardTransfer) {
        return cardTransferRepository.save(cardTransfer);
    }

    @Override
    @Transactional
    public CardTransfer updateCardTransferById(CardTransfer cardTransferToUpdate, long id) {
        final Optional<CardTransfer> optionalCardTransfer = getCardTransferById(id);

        // Проверяем, присутствует ли значение
        final CardTransfer cardTransfer = optionalCardTransfer.orElseThrow(() ->
                new IllegalArgumentException("CardTransfer not found for id: " + id));

        cardTransfer.setCardNumber(cardTransferToUpdate.getCardNumber());
        cardTransfer.setAmount(cardTransferToUpdate.getAmount());
        cardTransfer.setPurpose(cardTransferToUpdate.getPurpose());
        cardTransfer.setAccountDetailsId(cardTransferToUpdate.getAccountDetailsId());

        return cardTransfer;
    }


    @Override
    @Transactional
    public void deleteCardTransfer(Long id) {
        cardTransferRepository.deleteById(id);
    }

}
