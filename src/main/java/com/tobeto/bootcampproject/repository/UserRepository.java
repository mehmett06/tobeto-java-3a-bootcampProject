package com.tobeto.bootcampproject.repository;

import com.tobeto.bootcampproject.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findById(int id);

    User findByEmail(String email);

    User getByEmail(String email);

}
