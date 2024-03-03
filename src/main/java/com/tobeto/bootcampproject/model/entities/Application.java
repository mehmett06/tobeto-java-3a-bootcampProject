package com.tobeto.bootcampproject.model.entities;

import com.tobeto.bootcampproject.core.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Application")
public class Application extends BaseEntity<Integer> {

    @ManyToOne
    @JoinColumn(name="applicantId")
    private  Applicant applicant;

    @ManyToOne
    @JoinColumn(name="bootcampId")
    private  Bootcamp bootcamp;

    @ManyToOne
    @JoinColumn(name="applicationStateId")
    private  ApplicationState applicationState;

}
