package com.bank.transfer.service;

import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.repository.AccountTransferRepository;
import com.bank.transfer.serviceImpl.AccountTransferServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountTransferServiceTest {

    public static final Long ACCOUNT_TRANSFER_ID = 1L;
    public static final Long ACCOUNT_TRANSFER_NUMBER = 1938679L;

    @Mock
    private AccountTransferRepository accountTransferRepository;
    @InjectMocks
    private AccountTransferServiceImpl accountTransferService;

    @Test
    void findTransferByAccountNumber() {
        AccountTransfer expectedAccountTransfer = new AccountTransfer();
        expectedAccountTransfer.setId(ACCOUNT_TRANSFER_NUMBER);

        when(accountTransferRepository.findByAccountNumber(ACCOUNT_TRANSFER_NUMBER))
                .thenReturn(expectedAccountTransfer);

        AccountTransfer actualResult = accountTransferService
                .findTransferByAccountNumber(ACCOUNT_TRANSFER_NUMBER);
        // Проверяем результат
        assertNotNull(actualResult);
        assertEquals(expectedAccountTransfer.getId(), actualResult.getId());
        // Проверяем взаимодействия с моками
        verify(accountTransferRepository).findByAccountNumber(ACCOUNT_TRANSFER_NUMBER);
        verifyNoMoreInteractions(accountTransferRepository);
    }

    @Test
    void getAccountTransferById() {
    }

    @Test
    void allAccountTransfer() {
    }

    @Test
    void saveAccountTransfer() {
    }

    @Test
    void updateAccountTransferById() {
    }

    @Test
    void deleteAccountTransfer() {
    }
}