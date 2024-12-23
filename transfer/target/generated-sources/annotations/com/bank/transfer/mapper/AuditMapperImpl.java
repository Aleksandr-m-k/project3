package com.bank.transfer.mapper;

import com.bank.transfer.dto.AuditDTO;
import com.bank.transfer.entity.Audit;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-23T17:18:01+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class AuditMapperImpl implements AuditMapper {

    @Override
    public AuditDTO auditToAuditDTO(Audit audit) {
        if ( audit == null ) {
            return null;
        }

        AuditDTO.AuditDTOBuilder auditDTO = AuditDTO.builder();

        auditDTO.id( audit.getId() );
        auditDTO.entityType( audit.getEntityType() );
        auditDTO.operationType( audit.getOperationType() );
        auditDTO.createdBy( audit.getCreatedBy() );
        auditDTO.modifiedBy( audit.getModifiedBy() );
        auditDTO.createdAt( audit.getCreatedAt() );
        auditDTO.modifiedAt( audit.getModifiedAt() );
        auditDTO.newEntityJson( audit.getNewEntityJson() );
        auditDTO.entityJson( audit.getEntityJson() );

        return auditDTO.build();
    }

    @Override
    public Audit auditDTOToAudit(AuditDTO auditDTO) {
        if ( auditDTO == null ) {
            return null;
        }

        Audit.AuditBuilder audit = Audit.builder();

        audit.id( auditDTO.getId() );
        audit.entityType( auditDTO.getEntityType() );
        audit.operationType( auditDTO.getOperationType() );
        audit.createdBy( auditDTO.getCreatedBy() );
        audit.modifiedBy( auditDTO.getModifiedBy() );
        audit.createdAt( auditDTO.getCreatedAt() );
        audit.modifiedAt( auditDTO.getModifiedAt() );
        audit.newEntityJson( auditDTO.getNewEntityJson() );
        audit.entityJson( auditDTO.getEntityJson() );

        return audit.build();
    }

    @Override
    public List<AuditDTO> auditListToDTOList(List<Audit> audits) {
        if ( audits == null ) {
            return null;
        }

        List<AuditDTO> list = new ArrayList<AuditDTO>( audits.size() );
        for ( Audit audit : audits ) {
            list.add( auditToAuditDTO( audit ) );
        }

        return list;
    }
}
