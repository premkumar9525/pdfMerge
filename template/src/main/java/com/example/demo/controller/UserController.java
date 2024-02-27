package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("admin")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping("/page")
	public String page() {

		return "index";
	}

	@PostMapping("/saveuser")
	public String saveuser(@RequestParam("images") MultipartFile image, @ModelAttribute User user,Model model) {
		/* System.out.println(image + "::::::::" + user.toString()); */
		if (userRepository.existsByEmail(user.getEmail())) {
			String error =  "User Already Exist By Email !!!!!";
			model.addAttribute("error", error);
			return "index";
		} else {
			userService.creatUser(user, image);
			return "redirect:/admin/getuserlist";
		}

	}

	@GetMapping("/getuserlist")
	public String getuserlist(Model model) {
		/* System.out.println(":::::getList:::::::::::::::::::"); */
		List<User> list = userRepository.findAll();
		model.addAttribute("list", list);
		return "userlist";
	}

	@GetMapping("/editUserById/{id}")
	public String editUserById(@PathVariable("id") Long id, Model model) {
		System.out.println("::::::::::::::editUserById:::::::::::::::::::::");
		Optional<User> data = userRepository.findById(id);
		
		/* System.err.println("::::::::::::"+data.get()); */
		model.addAttribute("userinfo", data.get());
		return "useredit";
	}

	@PostMapping("/updateuser")
	public String updateuser(@ModelAttribute User user) {
		System.out.println("::::::::::"+user.getId());
		Optional<User> data = userRepository.findByid(user.getId());
		if (data.isPresent()) {
			userService.updateUser(user, data);
		}

		return "redirect:/admin/getuserlist";
	}
	
	@GetMapping("/deleteUserById/{id}")
	public String deleteUserBy(@PathVariable("id") Long id) {
		   Optional<User> data=userRepository.findById(id);
		   if (data.isPresent()) {  
			userService.deleteuserById(id);
		}
		   return "redirect:/admin/getuserlist";
	}

}
