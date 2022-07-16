package com.example.FullstackProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
public class FullstackProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackProjectApplication.class, args);
	}

}
