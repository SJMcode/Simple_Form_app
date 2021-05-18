package com.example.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class Controller1 {
	
	@RequestMapping(value="/basic", method=RequestMethod.GET)
	public String hello() {
		
		return "<h1>Hello</h1>";
	}

	@RequestMapping(value="/proper", method=RequestMethod.GET)
	public String helloproper() {
		
		return "<h1>Hello there, how are you</h1>";
	}
	
	@RequestMapping(value="/user_entry")
	public String form() {
		
		return "\n"
				+ "<form action=\"/greeting/user_greeting\", method=\"POST\">\n"
				+ "  <label for=\"fname\">First name:</label>\n"
				+ "  <input type=\"text\" id=\"fname\" name=\"fname\"><br><br>\n"
				+ "  <label for=\"lname\">Last name:</label>\n"
				+ "  <input type=\"text\" id=\"lname\" name=\"lname\"><br><br>\n"
				+ "  <input type=\"submit\" value=\"Submit\">\n"
				+ "</form>";
	}
	@RequestMapping(value="/user_greeting", method=RequestMethod.POST)

	public String userPrintGreeting(@RequestParam String fname,@RequestParam String lname) {
		
		return "Hi there " + fname+ " "+ lname;
	}
	
	@RequestMapping(value="/orders/{id}", method=RequestMethod.GET)
	public String orders(@PathVariable String id) {
		return "Orders: "+id;
	}
	

}
