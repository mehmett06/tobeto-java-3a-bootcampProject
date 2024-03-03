package com.tobeto.bootcampproject.repository;

import com.tobeto.bootcampproject.model.entities.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampRepository extends JpaRepository<Bootcamp,Integer> {
}
