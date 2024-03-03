package com.tobeto.bootcampproject.repository;

import com.tobeto.bootcampproject.model.entities.ApplicationState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationStateRepository extends JpaRepository<ApplicationState,Integer> {
}
