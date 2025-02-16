package com.chitkara.bootcamp.books.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldWithName {
	
	@GetMapping("hello/name")
	public String helloWorld(@RequestParam(name = "name") String name) {
		return "Hello " + name +"!";
	}

}
