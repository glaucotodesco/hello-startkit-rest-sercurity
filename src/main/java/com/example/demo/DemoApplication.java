package com.example.demo;

import java.util.Arrays;

import com.example.demo.model.UserLogin;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private UserRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
			UserLogin user    = new UserLogin("usr","123");
			UserLogin userAdm = new UserLogin("adm","123");

			repo.saveAll(Arrays.asList(user,userAdm));
	

	}

}
