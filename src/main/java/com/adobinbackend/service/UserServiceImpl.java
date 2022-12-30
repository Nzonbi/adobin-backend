package com.adobinbackend.service;

import com.adobinbackend.entities.AppRole;
import com.adobinbackend.entities.AppUser;
import com.adobinbackend.repo.RoleRepo;
import com.adobinbackend.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;
@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepo userRepo;
    RoleRepo roleRepo;
    @Override
    public Page<AppUser> getAllUsers(String mc, int page, int size) {
        return userRepo.chercherUser("%"+mc+"%", PageRequest.of(page,size));
    }
    @Override
    public Optional<AppUser> findUser(Long id) {

        Optional<AppUser> user =  userRepo.findById(id);
        if(!user.isPresent()) {
            throw new IllegalStateException(
                    "Usser with Id "+ id + "does not Exists !!!" );
        }
        return user;
    }

    @Override
    public AppUser findUserById(Long id) {
        return null;
    }

    @Override
    public AppUser updateUser(AppUser user, Long id) {
        AppUser users = userRepo.findById(id).orElseThrow(
                ()->new IllegalStateException("user not found"));

        if(user.getName()!="" &&
                !Objects.equals(users.getName(), user.getName())) {
            users.setName(user.getName());

        }
        if(user.getUsername()!="" &&
                !Objects.equals(users.getUsername(), user.getUsername())) {
            users.setUsername(user.getUsername());

        }
        if(user.getEmail()!="" &&
                !Objects.equals(users.getEmail(), user.getEmail())) {
            users.setEmail(user.getEmail());

        }

        if(user.getPhoto()!="" &&
                !Objects.equals(users.getPhoto(), user.getPhoto())) {
            users.setPhoto(user.getPhoto());

        }
        if(user.getSexe()!=null &&
                !Objects.equals(users.getSexe(), user.getSexe())) {
            users.setSexe(user.getSexe());

        }
        if(user.getPassWord()!="" &&
                !Objects.equals(users.getPassWord(), user.getPassWord())) {
            users.setPassWord(user.getPassWord());

        }
        return users;
    }

    @Override
    public AppUser getUser(String userName) {

        return null;
    }

    @Override
    public String deleteUser(Long id) {

        boolean exist = userRepo.existsById(id);
        if(!exist) {
            throw new IllegalStateException(
                    " User with Id "+ id + "does not exists !!!");
        }
        userRepo.deleteById(id);
        return "successful deleted";
    }

    @Override
    public AppUser saveUser(AppUser user) {

        return null;
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return null;
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {

    }

    @Override
    public void removeRoleToUser(String userName, String roleName) {

    }

    @Override
    public boolean desactivateUser(Long id) {
        return false;
    }

    @Override
    public boolean activateUser(Long id) {
        return false;
    }

    @Override
    public String confirm(String token) {
        return null;
    }

    @Override
    public AppUser seachByEmail(String email) {
        return null;
    }

    @Override
    public boolean deleteDesabledUser(String username) {
        return false;
    }
}
