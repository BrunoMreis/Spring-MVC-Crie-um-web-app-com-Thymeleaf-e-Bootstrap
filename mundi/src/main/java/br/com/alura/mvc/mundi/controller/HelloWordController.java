package br.com.alura.mvc.mundi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWordController {

	@GetMapping("/hello")
	public String helloWord() {
		
		return "hello.html";
	}
}
