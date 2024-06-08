package com.example.jenkinsexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class JenkinsExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsExerciseApplication.class, args);
	}

}

@RestController
@RequestMapping("/")
class Hello {

	@GetMapping
	public String greet(@RequestParam(defaultValue = "World", required = false) String value) {
		return "Hello " + value;
	}
}
