package org.cdac.services;

import java.util.List;

import org.cdac.DTO.UserDTO;

public interface UserService {
	
	public boolean registerUser(UserDTO objUser);
	public List<UserDTO> allUsers();
	public UserDTO findByUserName(String username);

}
