package com.bank.transfer.aspects;

import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.entity.Audit;
import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.entity.PhoneTransfer;
import com.bank.transfer.repository.AuditRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class AuditAspect {
    private final AuditRepository auditRepository; // Репозиторий для аудита
    private final ObjectMapper objectMapper; // ObjectMapper для преобразования в JSON

    @Autowired
    public AuditAspect(AuditRepository auditRepository) {
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
        Long id = extractId(result);
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Обработка исключения
        }

        Audit audit = Audit.builder()
                .entityType(result.getClass().getSimpleName())
                .operationType("CREATE")
                .createdBy(String.valueOf(id))
                .createdAt(LocalDateTime.now())
                .entityJson(jsonString)
                .build();

        auditRepository.save(audit);
        System.out.println("Audit saved: " + audit);
    }

    @AfterReturning(value = "updateMethod()", returning = "result")
    public void runUpdateMethods(Object result) {
        String entityType = result.getClass().getSimpleName();
        String jsonString = null;
        Long id = extractId(result);
        try {
            jsonString = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Обработка исключения
        }
        String createByString = String.valueOf(id);
        Audit audit = auditRepository.findByCreatedByAndOperationType(createByString, "CREATE");


        Audit updateAudit = Audit.builder()
                .entityType(entityType)
                .operationType("UPDATE")
                .createdBy(audit.getCreatedBy())
                .modifiedBy(String.valueOf(id))
                .createdAt(audit.getCreatedAt())
                .modifiedAt(LocalDateTime.now())
                .newEntityJson(jsonString)
                .entityJson(audit.getEntityJson())
                .build();

        auditRepository.save(updateAudit);
        System.out.println(updateAudit);
    }
    private Long extractId(Object result) {
        if (result instanceof AccountTransfer) {
            return ((AccountTransfer) result).getId();
        } else if (result instanceof PhoneTransfer) {
            return ((PhoneTransfer) result).getId();
        } else if (result instanceof CardTransfer) {
            return ((CardTransfer) result).getId();
        }
        return null; // Обработка случая, когда ID отсутствует
    }
}