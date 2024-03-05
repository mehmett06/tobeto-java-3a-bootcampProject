package com.tobeto.bootcampproject.repository;

import com.tobeto.bootcampproject.model.entities.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlacklistRepository extends JpaRepository<Blacklist, Integer> {
}
