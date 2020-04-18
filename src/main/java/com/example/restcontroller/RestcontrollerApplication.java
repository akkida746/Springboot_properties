package com.example.restcontroller;

import com.example.restcontroller.entity.User;
import com.example.restcontroller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestcontrollerApplication {

	@Autowired
	private UserService userService;

	@Autowired
	private User user;

	public static void main(String[] args) {
		SpringApplication.run(RestcontrollerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			System.out.println("Application started..");

			String appName = userService.getAppName();
			System.out.println("AppName: " + appName);

			String developer = userService.getDeveloperName();
			System.out.println("Developer: " + developer);

			System.out.println(userService.getDeveloperNameFromProperties());

			System.out.println("Developer: " + user.getName());
			System.out.println("User: " + user);

			System.out.println("Completed..");
		};
	}

}
