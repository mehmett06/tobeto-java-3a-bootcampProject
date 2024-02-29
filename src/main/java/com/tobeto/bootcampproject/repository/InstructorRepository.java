package com.tobeto.bootcampproject.repository;

import com.tobeto.bootcampproject.model.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Integer> {
}
