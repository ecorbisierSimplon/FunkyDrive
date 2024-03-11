package com.funkydrive.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funkydrive.backend.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>

{
    Optional<Role> findById(Long id);

}
