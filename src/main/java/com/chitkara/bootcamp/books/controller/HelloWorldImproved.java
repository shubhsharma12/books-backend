package com.chitkara.bootcamp.books.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldImproved {

	@GetMapping("hello/name")
	public ResponseEntity<String> helloWorld(@RequestParam(name = "name") String name) {
		if (name.isBlank() || name.isEmpty() || name.equalsIgnoreCase("admin")) {
			return ResponseEntity.badRequest().body("Error");
		}
		return ResponseEntity.ok("Hello " + name + "!");
	}

}
