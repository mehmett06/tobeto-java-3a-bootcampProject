package com.tobeto.bootcampproject.repository;

import com.tobeto.bootcampproject.model.entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant,Integer> {
}
