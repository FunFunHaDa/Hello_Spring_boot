package com.hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hello.domain.User;
import com.hello.domain.UserReposity;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserReposity userReposity;

	@GetMapping("/loginForm")
	public String loadingForm() {
		return "/user/login";
	}
	
	@GetMapping("/form")
	public String form() {
		System.out.println("@GetMapping(\"/form\")");
		return "user/form";
	}

	@PostMapping("")
	public String create(User user) {
		System.out.println("@PostMapping(\"\")");
		System.out.println("postmapping  " + user);
		userReposity.save(user);
		return "redirect:/users";
	}

	@GetMapping("")
	public String list(Model model) {
		System.out.println("@GetMapping(\"\")");
		System.out.println("model: " + model);
		model.addAttribute("users", userReposity.findAll());
		return "user/list";
	}

//	@GetMapping("/users")
//	public String list2(Model model) {
//		System.out.println("model: " + model);
//		model.addAttribute("users", userReposity.findAll());
//		return "user/list";
//	}

	@GetMapping("/{id}/form")
	public String updateForm(@PathVariable Long id, Model model) {
		System.out.println("@GetMapping(\"/{id}/form\")");
		User user = userReposity.findById(id).get();
		model.addAttribute("user", user);
		return "user/updateForm";
	}

	@PutMapping("/{id}")
	public String update(@PathVariable Long id, User newUser) {
		System.out.println("@PostMapping(\"/{id}\")");
		User user = userReposity.findById(id).get();
		user.update(newUser);
		userReposity.save(user);
		return "redirect:/users";
	}
}
