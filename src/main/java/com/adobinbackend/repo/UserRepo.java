package com.adobinbackend.repo;

import com.adobinbackend.entities.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
    @Query("SELECT u FROM AppUser u WHERE u.name LIKE :#{#x}")
    public Page<AppUser> chercherUser(@Param("x") String mc, Pageable pageable);
}
