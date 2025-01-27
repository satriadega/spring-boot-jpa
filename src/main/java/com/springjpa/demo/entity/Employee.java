package com.springjpa.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Employee {

  @SuppressWarnings("deprecation")
  @Id
  @GeneratedValue(generator = "CustomUUIDGenerator")
  @GenericGenerator(name = "CustomUUIDGenerator", strategy = "com.springjpa.demo.generator.CustomUUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false, length = 50)
  private String id;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(length = 100)
  private String position;

  @Column(nullable = false, unique = true, length = 100)
  private String email;

  @CreatedDate
  @Column(name = "created_at", updatable = false, nullable = false)
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;
}
