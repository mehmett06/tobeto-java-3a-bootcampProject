package com.tobeto.bootcampproject.repository;

import com.tobeto.bootcampproject.model.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
Application getById(int id);
}
