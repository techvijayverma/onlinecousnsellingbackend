package org.cdac.controllers;

import java.util.List;

import org.cdac.DTO.UserDTO;
import org.cdac.entity.User;
import org.cdac.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/{uname}")
	public UserDTO getUserDetails(@PathVariable("uname") String username) {
		return userService.findByUserName(username);
	}

	@PostMapping("/register")
	public boolean registerUser(@RequestBody UserDTO dto) {
		return userService.registerUser(dto);
	}
	
	
	@GetMapping("/")
	public List<UserDTO> allUsers() {
		return userService.allUsers();
	}

	/*
	 * @GetMapping("defaultUser") public User getDefaultUser() { return new User();
	 * }
	 * 
	 * @GetMapping("authenticate") public boolean
	 * authenticate(@RequestParam(name="uname")String
	 * username,@RequestParam(name="pwd")String password) {
	 * if(username.equals("default")&&password.equals("defaultPassword")) return
	 * true; return false; }
	 * 
	 * @GetMapping("auth/{uname}") public boolean auth(@PathVariable("uname") String
	 * username) { if(username.equals("default")) return true; return false; }
	 */ 
	@PostMapping("/authenticate")
	public boolean authenticate(@RequestBody UserDTO objUser) {
		
		UserDTO dtoObject=new UserDTO();
		dtoObject=userService.findByUserName(objUser.getUsername());
		if (objUser.getUsername().equals(dtoObject.getUsername()) && objUser.getPassword().equals(dtoObject.getPassword()))
			return true;
		return false;
	}
	  
	 }
