package com.example.finalProject.repositories.security;

import com.example.finalProject.entities.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
