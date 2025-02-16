package com.chitkara.bootcamp.books.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {
	
	@GetMapping("hello")
	public String helloWorld() {
		return "Hello World";
	}

}
