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
    private PhoneTransferRepository phoneTransferRepository;

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
    public PhoneTransfer findTransferbyPhoneNumber(Long phoneNumber) {
        return phoneTransferRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    @Transactional
    public List<PhoneTransfer> allPhoneTransfer() {
        return phoneTransferRepository.findAll();
    }

    @Override
    @Transactional
    public PhoneTransfer saveOrUpdatePhoneTransfer(PhoneTransfer phoneTransfer) {
        return phoneTransferRepository.saveAndFlush(phoneTransfer);
    }

    @Override
    @Transactional
    public void deletePhoneTransfer(Long id) {
        phoneTransferRepository.deleteById(id);
    }

}
