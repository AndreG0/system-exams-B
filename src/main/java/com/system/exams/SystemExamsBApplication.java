package com.system.exams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemExamsBApplication  {



	public static void main(String[] args) {
		SpringApplication.run(SystemExamsBApplication.class, args);
	}
/*
	@Override
	public void run(String... args) throws Exception { implements CommandLineRunner

		User user = new User();
		user.setName("Andrea");
		user.setLastname("Gomez");
		user.setUsername("Andrego");
		user.setProfile("12345");
		user.setEmail("a1@mail.com");
		user.setNumber("9876543");
		user.setPassword("12345");
		user.setProfile("foto.png");

		Role role = new Role();
		role.setRoleId(1l);
		role.setName("ADMIN");

		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoles.add(userRole);

		User saveUser = userService.save(user, userRoles);
		System.out.println(saveUser.getUsername());


	}
 */

}
