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
	
	
	@PostMapping("/updateprofile")
	public boolean updateProfile(@RequestBody UserDTO dto) {
		return userService.updateProfile(dto);
	}
	
	
	@GetMapping("/allusers")
	public List<UserDTO> allUsers(@RequestParam String userType){
		return userService.allUsers(userType);
		
	}
	
	
//	@GetMapping("/allusers")
//	public List<UserDTO> allUsers() {
//		return userService.allUsers();
//	}

	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody UserDTO dtoUser) {
		return userService.authenticate(dtoUser);
	}
	
	@PostMapping("/changepassword")
	public boolean changePassword(@RequestBody UserDTO dtoUser)
	{
		
		return userService.changePassword(dtoUser);
		
		
	}
	  
	 }
