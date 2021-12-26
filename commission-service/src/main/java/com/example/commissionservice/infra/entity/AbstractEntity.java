package com.example.commissionservice.infra.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Data
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    Long id;
    @Column(unique = true)
    String ref;
    @CreatedDate
    Instant createdAt;
    @LastModifiedDate
    Instant updatedAt;

}
