package com.tobeto.bootcampproject.model.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Applicant")
@PrimaryKeyJoinColumn(name="user_ıd")
@Entity
public class Applicant extends User{
    @Column(name="about")
    private String about;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.REMOVE)
    private List<Application> applications;
}
