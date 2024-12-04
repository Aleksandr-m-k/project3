package com.bank.transfer.aspects;

import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.entity.Audit;
import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.entity.PhoneTransfer;
import com.bank.transfer.repository.AuditRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@Aspect
public class AuditTransferAspect {
    private final AuditRepository auditRepository; // Репозиторий для аудита
    private final ObjectMapper objectMapper; // ObjectMapper для преобразования в JSON

    @Autowired
    public AuditTransferAspect(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
        this.objectMapper = new ObjectMapper(); // Инициализация ObjectMapper
    }

    @Pointcut("execution(* save*Transfer(..))")
    public void createMethod() {
    }

    @Pointcut("execution(* update*Transfer(..))")
    public void updateMethod() {
    }

    @AfterReturning(value = "createMethod()", returning = "result")
    public void runSaveMethods(Object result) {
        Long id = null;
        String jsonString = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonString = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Обработка исключения
        }
        if (result instanceof AccountTransfer) {
            AccountTransfer accountTransfer = (AccountTransfer) result;
            id = (Long) accountTransfer.getId();
        } else if (result instanceof PhoneTransfer) {
            PhoneTransfer phoneTransfer = (PhoneTransfer) result;
            id = (Long) phoneTransfer.getId();

        } else if (result instanceof CardTransfer) {
            CardTransfer cardTransfer = (CardTransfer) result;
            id = (Long) cardTransfer.getId();
        }

        Audit audit = Audit.builder()
                .entityType(result.getClass().getSimpleName())
                .operationType("CREATE")
                .createdBy(String.valueOf(id))
                .modifiedAt(null)
                .createdAt(LocalDateTime.now())
                .modifiedAt(null)
                .newEntityJson(null)
                .entityJson(jsonString)
                .build();

        auditRepository.save(audit);
        System.out.println("Audit saved: " + audit);
    }

    @AfterReturning(value = "updateMethod()", returning = "result")
    public void runUpdateMethods(Object result) {
        String jsonString = null;
        Long id=null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonString = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Обработка исключения
        }
        if (result instanceof AccountTransfer) {
            AccountTransfer accountTransfer = (AccountTransfer) result;
            id = (Long) accountTransfer.getId();
        } else if (result instanceof PhoneTransfer) {
            PhoneTransfer phoneTransfer = (PhoneTransfer) result;
            id = (Long) phoneTransfer.getId();

        } else if (result instanceof CardTransfer) {
            CardTransfer cardTransfer = (CardTransfer) result;
            id = (Long) cardTransfer.getId();
        }
        String createByString=String.valueOf(id);
       Audit audit = auditRepository.findByCreatedBy(createByString);



        Audit updateAudit = Audit.builder()
                .entityType(result.getClass().getSimpleName())
                .operationType("UPDATE")
                .createdBy(audit.getCreatedBy())
                .modifiedBy(String.valueOf(id))
                .createdAt(audit.getCreatedAt())
                .modifiedAt(LocalDateTime.now())
                .newEntityJson(jsonString)
                .entityJson(String.valueOf(audit))
                .build();

        auditRepository.save(updateAudit);
        System.out.println("обновлена сущность");
        System.out.println(updateAudit);
    }
}