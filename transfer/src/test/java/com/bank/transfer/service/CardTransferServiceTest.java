package com.bank.transfer.service;

import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.repository.CardTransferRepository;
import com.bank.transfer.serviceImpl.CardTransferServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CardTransferServiceTest {
    public static final Long CARD_TRANSFER_ID = 1L;
    public static final Long CARD_TRANSFER_NUMBER = 1L;

    @Mock
    private CardTransferRepository cardTransferRepository;
    @InjectMocks
    private CardTransferServiceImpl cardTransferService;

    CardTransfer cardTransfer1;
    CardTransfer cardTransfer2;

    @BeforeEach
    public void creatNewCardTransfer() {
        cardTransfer1 = new CardTransfer(1L, new BigDecimal("39654.34"), "purpose1", 5L);
        cardTransfer2 = new CardTransfer(2L, new BigDecimal("34.34"), "purpose2", 6L);

    }

    @Test
    void findTransferByCardNumber() {
        cardTransfer1.setCardNumber(CARD_TRANSFER_NUMBER);

        when(cardTransferRepository.findByCardNumber(CARD_TRANSFER_NUMBER))
                .thenReturn(cardTransfer1);

        CardTransfer actualResult = cardTransferService
                .findTransferByCardNumber(CARD_TRANSFER_NUMBER);
        assertNotNull(actualResult);
        assertEquals(cardTransfer1.getId(), actualResult.getId());
        // Проверяем взаимодействия с моками
        verify(cardTransferRepository).findByCardNumber(CARD_TRANSFER_ID);
        verifyNoMoreInteractions(cardTransferRepository);
    }

    @Test
    void getCardTransferById() {

        when(cardTransferRepository.findById(CARD_TRANSFER_ID))
                .thenReturn(Optional.of(cardTransfer1));
        Optional<CardTransfer> cardTransfer = cardTransferService.getCardTransferById(CARD_TRANSFER_ID);
        assertEquals(Optional.of(cardTransfer1), cardTransfer);
        assertNotNull(cardTransfer);
    }

    @Test
    void allCardTransfer() {
        when(cardTransferRepository.findAll())
                .thenReturn(new ArrayList<CardTransfer>(List.of(cardTransfer1, cardTransfer2)));
        List<CardTransfer> allCardTransfers = cardTransferService.allCardTransfer();
        List<CardTransfer> expectedTransfers = new ArrayList<>(List.of(cardTransfer1, cardTransfer2));
        assertEquals(expectedTransfers, allCardTransfers, "Списки CardTransfer должны быть равны");
    }

    @Test
    void saveCardTransfer() {
        when(cardTransferService.saveCardTransfer(cardTransfer1))
                .thenReturn(cardTransfer1);
        CardTransfer saveCardTransfer = cardTransferRepository.save(cardTransfer1);
        assertEquals(saveCardTransfer, cardTransfer1);
    }

    @Test
    void updateCardTransferById() {
        CardTransfer existingCardTransfer =
                new CardTransfer(CARD_TRANSFER_ID, CARD_TRANSFER_NUMBER, new BigDecimal("39654.34"), "purpose", 5L);
        CardTransfer cardTransferToUpdate = new CardTransfer();
        cardTransferToUpdate.setCardNumber(3L);
        cardTransferToUpdate.setAmount(new BigDecimal("500.55"));
        cardTransferToUpdate.setPurpose("newPurpose");
        cardTransferToUpdate.setCardDetailsId(56L);

        when(cardTransferRepository.findById(CARD_TRANSFER_ID))
                .thenReturn(Optional.of(existingCardTransfer));

        CardTransfer updateCardTransfer =
                cardTransferService.updateCardTransferById(cardTransferToUpdate, CARD_TRANSFER_ID);

        assertEquals(3L, updateCardTransfer.getCardNumber());
        assertEquals(new BigDecimal("500.55"), updateCardTransfer.getAmount());
        assertEquals("newPurpose", updateCardTransfer.getPurpose());
        assertEquals(56L, updateCardTransfer.getCardDetailsId());
    }

    @Test
    void updateCardTransferByIdShouldThrowExceptionWhenCardTransferIsNull() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cardTransferService.updateCardTransferById(null, CARD_TRANSFER_ID);
        });

        Assertions.assertEquals("CardTransfer to update cannot be null", exception.getMessage());
    }

    @Test
    void deleteCardTransfer() {
        cardTransferService.deleteCardTransfer(CARD_TRANSFER_ID);
        verify(cardTransferRepository).deleteById(CARD_TRANSFER_ID);
    }
}
