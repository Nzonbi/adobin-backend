package com.adobinbackend.repo;

import com.adobinbackend.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<AppRole,Long> {
    AppRole findByName(String roleName);
}
