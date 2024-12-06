package com.bank.transfer.repository;

import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.entity.Audit;
import com.bank.transfer.entity.CardTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AuditRepository extends JpaRepository<Audit, Long> {
     Audit findByCreatedByAndOperationType(String createAt,String operationType);


}
