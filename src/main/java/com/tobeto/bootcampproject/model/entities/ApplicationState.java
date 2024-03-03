package com.tobeto.bootcampproject.model.entities;

import com.tobeto.bootcampproject.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ApplicationState")
@EqualsAndHashCode(callSuper = true)
public class ApplicationState extends BaseEntity<Integer> {
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "applicationState")
    private List<Application> applicationsList;

}
