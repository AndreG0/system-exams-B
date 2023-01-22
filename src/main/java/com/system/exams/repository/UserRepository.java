package com.system.exams.repository;

import com.system.exams.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByusername(String username);


    User findByName(String name);

    boolean existsByName(String name);



}
