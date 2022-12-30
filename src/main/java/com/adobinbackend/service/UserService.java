package com.adobinbackend.service;

import com.adobinbackend.entities.AppRole;
import com.adobinbackend.entities.AppUser;
import com.adobinbackend.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Page<AppUser> getAllUsers(String mc, int page, int size);
    Optional<AppUser> findUser(Long id);
    AppUser findUserById(Long id);

    AppUser updateUser(AppUser user,Long id);
    AppUser getUser(String userName);
    String  deleteUser(Long id);
    AppUser saveUser(AppUser user);
    AppRole saveRole(AppRole role);
    void addRoleToUser(String userName,String roleName);
    void removeRoleToUser(String userName,String roleName);
    boolean desactivateUser(Long id);
    boolean activateUser(Long id);
    String confirm(String token);
    AppUser seachByEmail(String email);
    boolean deleteDesabledUser(String username);

}
