package org.cdac.services;

import java.util.List;

import org.cdac.DTO.UserDTO;

public interface UserService {
	
	public boolean registerUser(UserDTO objUser);
	//public List<UserDTO> allUsers();
	public UserDTO findByUserName(String username);
	public boolean changePassword(UserDTO dtoObject);
	public boolean updateProfile(UserDTO objUser);
	public String authenticate(UserDTO dtoUser);
	public List<UserDTO> allUsers(String userType);

}
