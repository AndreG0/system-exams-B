package com.system.exams.controller;

import com.system.exams.dto.Message;
import com.system.exams.entity.Role;
import com.system.exams.entity.User;
import com.system.exams.entity.UserRole;
import com.system.exams.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
    @RequestMapping("/users")
    @CrossOrigin("*")
    public class UserController {

    @Autowired
    UserService userService;


        @GetMapping("/list")
        public ResponseEntity<List<User>> list(){
            List<User> list = userService.list();
            return new ResponseEntity<List<User>>(list, HttpStatus.OK);
        }

        @GetMapping("/detail/{id}")
        public ResponseEntity<User> getById(@PathVariable("id") int id){
            if (!userService.existById(id))
                return new ResponseEntity(new Message("Doesn't Exist"), HttpStatus.NOT_FOUND);
            User user = userService.getOne(id).get();
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }

/*
    @GetMapping("detail/{name}")
        public ResponseEntity<User> getByName(@PathVariable("name") String name){
            if (userService.existByName(name))
                return new ResponseEntity(new Message("Doesn't Exist"), HttpStatus.NOT_FOUND);

            User user = userService.getByName(name).get();
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
*/

        @PostMapping("/create")
        public User saveUser (@RequestBody User user ) throws Exception{
            user.setProfile("default.png");
            Set<UserRole> userRoles = new HashSet<>();

            Role role = new Role();
            role.setRoleId(2);
            role.setRolName("USER");

            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);

            userRoles.add(userRole);
            return userService.saveUser(user, userRoles);
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id){
            if(!userService.existById(id))
                return  new ResponseEntity(new Message("Doesn't Exist"),HttpStatus.NOT_FOUND);
            userService.delete(id);
            return  new ResponseEntity(new Message("Item Removed"), HttpStatus.OK);
        }

}
