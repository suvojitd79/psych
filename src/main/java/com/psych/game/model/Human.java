package com.psych.game.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@JsonIgnoreProperties(value = {"createdAt","updatedAt"}, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public abstract class Human implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Getter @Setter
    private Date createdAt;

    @Column(nullable = false, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Getter @Setter
    private Date updatedAt;

}