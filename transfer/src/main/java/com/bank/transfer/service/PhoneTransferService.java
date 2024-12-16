package com.bank.transfer.service;

import com.bank.transfer.entity.PhoneTransfer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PhoneTransferService {

    Optional<PhoneTransfer> getPhoneTransferById(Long id);

    List<PhoneTransfer> allPhoneTransfer();

    PhoneTransfer savePhoneTransfer(PhoneTransfer phoneTransfer);

    PhoneTransfer updatePhoneTransferById(PhoneTransfer phoneTransfer, long id);

    void deletePhoneTransfer(Long id);
}
