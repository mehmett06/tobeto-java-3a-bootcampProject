package com.tobeto.bootcampproject.model.entities;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name="user_id")
@Table(name="instructors")

public class Instructor extends User{
    @Column(name="companyName")
    private String companyName;

    @OneToMany(mappedBy = "instructor")
    private List<Bootcamp> bootcamps;
}
