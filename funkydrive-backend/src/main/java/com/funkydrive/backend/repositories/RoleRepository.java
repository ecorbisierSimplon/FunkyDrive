package com.funkydrive.backend.repositories;

<<<<<<< HEAD
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funkydrive.backend.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>

{
    Optional<Role> findById(Long id);
=======
public interface RoleRepository {
>>>>>>> e8f30c9434cc8947c82315a838973b98171dd97e

}
