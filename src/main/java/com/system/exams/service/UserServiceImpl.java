package com.system.exams.service;


import com.system.exams.entity.User;
import com.system.exams.entity.UserRole;
import com.system.exams.repository.RoleRepository;
import com.system.exams.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User save(User user, Set<UserRole> userRoles) throws Exception {
       User localUser = userRepository.findByUsername(user.getUsername());
       if(localUser != null){
           System.out.println("This user already exists");
           throw new Exception("The user is already present");
       }else{
           for (UserRole userRole: userRoles){
               roleRepository.save(userRole.getRole());
           }
           user.getUserRoles().addAll(userRoles);
           localUser = userRepository.save(user);
       }
       return localUser;
    }
}
