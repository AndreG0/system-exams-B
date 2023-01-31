package com.system.exams.service;


import com.system.exams.entity.User;
import com.system.exams.entity.UserRole;
import com.system.exams.exceptions.UserFoundException;
import com.system.exams.repository.RoleRepository;
import com.system.exams.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    public List<User> list(){
        return userRepository.findAll();
    }

    public Optional<User> getOne(int id){
        return userRepository.findById(id);
    }


    public User saveUser (User user, Set<UserRole> userRoles)throws Exception{

      User localUser = userRepository.findByName(user.getName());
        if (localUser != null){
            System.out.println("el usuario ya existe");
            throw new UserFoundException("el usuario ya esta presente");
        }
        else {
            for (UserRole userRole:userRoles){
                roleRepository.save(userRole.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            localUser = userRepository.save(user);
        }

        return localUser;
    }


    public void delete(int id){
        userRepository.deleteById(id);
    }

    public boolean existById(int id){
        return userRepository.existsById(id);
    }

    public boolean existByName(String name){
        return userRepository.existsByName(name);
    }

    public User getUser(String username){
        return userRepository.findByusername(username);
    }



}
