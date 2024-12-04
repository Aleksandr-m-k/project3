package com.bank.transfer.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit", schema = "transfer")
@ToString
@Setter
@Getter
@NoArgsConstructor
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_type")
//    @Size(max = 40)
    private String entityType;

    @Column(name = "operation_type")
//    @Size(max = 255)
    private String operationType;

    @Column(name = "created_by")
//    @Size(max = 255)
    private String createdBy;

    @Column(name = "modified_by")
//    @Size(max = 40)
    private String modifiedBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Column(name = "new_entity_json")
    private String newEntityJson;

    @Column(name = "entity_json")
    private String entityJson;



    @Builder
    public Audit(String entityType, String operationType, String createdBy,
                 String modifiedBy, LocalDateTime createdAt, LocalDateTime modifiedAt,
                 String newEntityJson, String entityJson) {
        this.entityType = entityType;
        this.operationType = operationType;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.newEntityJson = newEntityJson;
        this.entityJson = entityJson;
    }


}
