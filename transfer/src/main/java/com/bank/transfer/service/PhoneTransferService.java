package com.bank.transfer.service;

import com.bank.transfer.entity.PhoneTransfer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PhoneTransferService {
    PhoneTransfer findTransferbyPhoneNumber(Long PhoneNumber);
    Optional<PhoneTransfer> getPhoneTransferById(Long id);

    List<PhoneTransfer> allPhoneTransfer();

    PhoneTransfer saveOrUpdatePhoneTransfer(PhoneTransfer phoneTransfer);

    void deletePhoneTransfer(Long id);
}
