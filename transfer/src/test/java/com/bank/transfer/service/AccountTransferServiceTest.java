package com.bank.transfer.service;

import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.repository.AccountTransferRepository;
import com.bank.transfer.serviceImpl.AccountTransferServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountTransferServiceTest {

    public static final Long ACCOUNT_TRANSFER_ID = 1L;
    public static final Long ACCOUNT_TRANSFER_NUMBER = 1L;

    @Mock
    private AccountTransferRepository accountTransferRepository;
    @InjectMocks
    private AccountTransferServiceImpl accountTransferService;

    AccountTransfer accountTransfer1;
    AccountTransfer accountTransfer2;

    @BeforeEach
    public void creatNewAccountTransfer() {
        accountTransfer1 = new AccountTransfer(1L, new BigDecimal("39654.34"), "purpose1", 5L);
        accountTransfer2 = new AccountTransfer(2L, new BigDecimal("34.34"), "purpose2", 6L);

    }

    @Test
    void findTransferByAccountNumber() {
        accountTransfer1.setAccountNumber(ACCOUNT_TRANSFER_NUMBER);

        when(accountTransferRepository.findByAccountNumber(ACCOUNT_TRANSFER_NUMBER))
                .thenReturn(accountTransfer1);

        AccountTransfer actualResult = accountTransferService
                .findTransferByAccountNumber(ACCOUNT_TRANSFER_NUMBER);
        assertNotNull(actualResult);
        assertEquals(accountTransfer1.getId(), actualResult.getId());
        // Проверяем взаимодействия с моками
        verify(accountTransferRepository).findByAccountNumber(ACCOUNT_TRANSFER_NUMBER);
        verifyNoMoreInteractions(accountTransferRepository);
    }

    @Test
    void getAccountTransferById() {

        Mockito.when(accountTransferRepository.findById(ACCOUNT_TRANSFER_ID))
                .thenReturn(Optional.of(accountTransfer1));
        Optional<AccountTransfer> accountTransfer = accountTransferService.getAccountTransferById(ACCOUNT_TRANSFER_ID);
        assertEquals(Optional.of(accountTransfer1), accountTransfer);
        assertNotNull(accountTransfer);
    }

    @Test
    void allAccountTransfer() {
        Mockito.when(accountTransferRepository.findAll())
                .thenReturn(new ArrayList<AccountTransfer>(List.of(accountTransfer1, accountTransfer2)));
        List<AccountTransfer> allAccountTransfers = accountTransferService.allAccountTransfer();
        List<AccountTransfer> expectedTransfers = new ArrayList<>(List.of(accountTransfer1, accountTransfer2));
        assertEquals(expectedTransfers, allAccountTransfers, "Списки AccountTransfer должны быть равны");
    }

    @Test
    void saveAccountTransfer() {
        Mockito.when(accountTransferService.saveAccountTransfer(accountTransfer1))
                .thenReturn(accountTransfer1);
        AccountTransfer saveAccountTransfer = accountTransferRepository.save(accountTransfer1);
        assertEquals(saveAccountTransfer, accountTransfer1);
    }

    @Test
    void updateAccountTransferById() {
        AccountTransfer existingAccountTransfer =
                new AccountTransfer(ACCOUNT_TRANSFER_ID, ACCOUNT_TRANSFER_NUMBER, new BigDecimal("39654.34"), "purpose", 5L);
        AccountTransfer accountTransferToUpdate = new AccountTransfer();
        accountTransferToUpdate.setAccountNumber(3L);
        accountTransferToUpdate.setAmount(new BigDecimal("500.55"));
        accountTransferToUpdate.setPurpose("newPurpose");
        accountTransferToUpdate.setAccountDetailsId(56L);

        Mockito.when(accountTransferRepository.findById(ACCOUNT_TRANSFER_ID))
                .thenReturn(Optional.of(existingAccountTransfer));

        AccountTransfer updateAccountTransfer =
                accountTransferService.updateAccountTransferById(accountTransferToUpdate, ACCOUNT_TRANSFER_ID);

        assertEquals(3L, updateAccountTransfer.getAccountNumber());
        assertEquals(new BigDecimal("500.55"), updateAccountTransfer.getAmount());
        assertEquals("newPurpose", updateAccountTransfer.getPurpose());
        assertEquals(56L, updateAccountTransfer.getAccountDetailsId());
    }

    @Test
    void updateAccountTransferByIdShouldThrowExceptionWhenAccountTransferIsNull() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            accountTransferService.updateAccountTransferById(null, ACCOUNT_TRANSFER_ID);
        });

        Assertions.assertEquals("AccountTransfer to update cannot be null", exception.getMessage());
    }

    @Test
    void deleteAccountTransfer() {
        accountTransferService.deleteAccountTransfer(ACCOUNT_TRANSFER_ID);
        verify(accountTransferRepository).deleteById(ACCOUNT_TRANSFER_ID);
    }
}
