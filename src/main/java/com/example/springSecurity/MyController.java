package com.example.springSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/manager")
	public String manager() {
		return "this is manager";
	}

	@GetMapping("/trainer")
	public String trainer() {
		return "this is trainer";
	}

	@GetMapping("/student")
	public String student() {
		return "this is student";
	}

	@GetMapping("/teacher")
	public String teacher() {
		return "this is teacher";
	}

	@GetMapping("/principle")
	public String principle() {
		return "this is principle";
	}
}
