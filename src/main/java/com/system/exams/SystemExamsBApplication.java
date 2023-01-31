package com.system.exams;

import com.system.exams.entity.Role;
import com.system.exams.entity.User;
import com.system.exams.entity.UserRole;
import com.system.exams.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SystemExamsBApplication  {


@Autowired
private UserService userService;

@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SystemExamsBApplication.class, args);
	}


	public void run(String... args) throws Exception {
/*
		User user = new User();

		user.setName("Andrea");
		user.setLastname("Gomez");
		user.setUsername("andrego");
		user.setProfile("12345");
		user.setEmail("a1@mail.com");
		user.setNumber("9876543");
		user.setPassword(bCryptPasswordEncoder.encode("12345"));
		user.setProfile("foto.png");

		Role role = new Role();
		role.setRoleId(1);
		role.setRolName("ADMIN");

		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoles.add(userRole);

		User saveUser = userService.saveUser(user, userRoles);
		System.out.println(saveUser.getUsername());


	}
*/

	}}
