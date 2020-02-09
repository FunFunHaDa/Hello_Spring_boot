package com.hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hello.domain.User;
import com.hello.domain.UserReposity;

@Controller
public class UserController {
	
	@Autowired
	private UserReposity userReposity;
	
	@PostMapping("/create")
	public String create(User user)
	{
		System.out.println(user);
		userReposity.save(user);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(Model model)
	{
		System.out.println("model: "+ model);
		model.addAttribute("users", userReposity.findAll());
		return "list";
	}

}
