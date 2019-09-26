package com.common.common;

import com.common.common.model.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CommonApplication {
	public static void main(String[] args) {
		User user;
		SpringApplication.run(CommonApplication.class, args);

	}

}
