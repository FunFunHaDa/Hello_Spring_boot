package com.hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hello.domain.User;
import com.hello.domain.UserReposity;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserReposity userReposity;
	
	
	@GetMapping("/form")
	public String form() {
		return "/user/form";
	}
	
	@PostMapping("")
	public String create(User user)
	{
		System.out.println("postmapping  "+user);
		userReposity.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("")
	public String list(Model model)
	{
		System.out.println("model: "+ model);
		model.addAttribute("users", userReposity.findAll());
		return "/user/list";
	}
	
	@GetMapping("/{id}/form")
	public String updateForm(@PathVariable Long id, Model model) {
		User user = userReposity.findById(id).get();
		model.addAttribute("user", user);
		return "/user/updateForm";
	}
	

}
