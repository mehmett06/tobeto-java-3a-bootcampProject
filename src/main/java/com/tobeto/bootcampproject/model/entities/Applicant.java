package com.tobeto.bootcampproject.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Applicant")
@PrimaryKeyJoinColumn(name="user_ıd")
@Entity
public class Applicant extends User{
    private String about;
}
