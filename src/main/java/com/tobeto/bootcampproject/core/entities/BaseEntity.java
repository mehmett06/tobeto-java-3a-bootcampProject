package com.tobeto.bootcampproject.core.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass

public class BaseEntity<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private T id;
    @Column(name="CREATED")
    private LocalDateTime createdTime;
    @Column(name="UPDATE")
    private LocalDateTime update;
    @Column(name="DELETE")
    private LocalDateTime delete;

}
