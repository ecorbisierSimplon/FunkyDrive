package com.funkydrive.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.funkydrive.backend.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @SuppressWarnings("unchecked")
    User save(User user);

    Optional<User> findById(Long id);

    long count();
}
