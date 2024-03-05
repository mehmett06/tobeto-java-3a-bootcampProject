package com.tobeto.bootcampproject.model.entities;

import com.tobeto.bootcampproject.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bootcampState")
@EqualsAndHashCode(callSuper = true)
public class BootcampState extends BaseEntity<Integer> {
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "bootcampState")
    private List<Bootcamp> bootcampList;
}
