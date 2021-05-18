package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.User;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("formData", new User());
		return "index";
	}
	
	@RequestMapping(value="/create" , method=RequestMethod.POST)
	public String processForm(User user, RedirectAttributes attr) {
		attr.addFlashAttribute("user", user);
		return "redirect:/display";
	}

	
	@RequestMapping(value="/display" , method=RequestMethod.GET)
	public String disaplayFormdata(User user) {
		return "result";
	}

}
