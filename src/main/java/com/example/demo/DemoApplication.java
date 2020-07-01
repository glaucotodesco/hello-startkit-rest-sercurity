package com.example.demo;

import java.util.Arrays;

import com.example.demo.model.UserLogin;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private UserRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
			UserLogin user    = new UserLogin("usr",encoder.encode("123"));
			UserLogin userAdm = new UserLogin("adm",encoder.encode("123"));

			repo.saveAll(Arrays.asList(user,userAdm));
	

	}

}
