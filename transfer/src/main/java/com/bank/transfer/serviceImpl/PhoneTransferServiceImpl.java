package com.bank.transfer.serviceImpl;

import com.bank.transfer.entity.PhoneTransfer;
import com.bank.transfer.repository.PhoneTransferRepository;
import com.bank.transfer.service.PhoneTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneTransferServiceImpl implements PhoneTransferService {
    private final PhoneTransferRepository phoneTransferRepository;

    @Autowired
    public PhoneTransferServiceImpl(PhoneTransferRepository phoneTransferRepository) {
        this.phoneTransferRepository = phoneTransferRepository;
    }

    @Override
    @Transactional
    public Optional<PhoneTransfer> getPhoneTransferById(Long id) {
        return phoneTransferRepository.findById(id);
    }


    @Override
    @Transactional
    public List<PhoneTransfer> allPhoneTransfer() {
        return phoneTransferRepository.findAll();
    }


    @Override
    @Transactional
    public PhoneTransfer savePhoneTransfer(PhoneTransfer phoneTransfer) {
        return phoneTransferRepository.save(phoneTransfer);
    }

    @Override
    @Transactional
    public PhoneTransfer updatePhoneTransferById(PhoneTransfer phoneTransferToUpdate, long id) {
        if (phoneTransferToUpdate == null) {
            throw new IllegalArgumentException("PhoneTransfer to update cannot be null");
        }
        final  Optional<PhoneTransfer> optionalPhoneTransfer = getPhoneTransferById(id);

        // Проверяем, присутствует ли значение
        final PhoneTransfer phoneTransfer = optionalPhoneTransfer.orElseThrow(() ->
                new IllegalArgumentException("CardTransfer not found for id: " + id));
        phoneTransfer.setPhoneNumber(phoneTransferToUpdate.getPhoneNumber());
        phoneTransfer.setAmount(phoneTransferToUpdate.getAmount());
        phoneTransfer.setPurpose(phoneTransferToUpdate.getPurpose());
        phoneTransfer.setAccountDetailsId(phoneTransferToUpdate.getAccountDetailsId());
        return phoneTransfer;
    }

    @Override
    @Transactional
    public void deletePhoneTransfer(Long id) {
        phoneTransferRepository.deleteById(id);
    }

}
