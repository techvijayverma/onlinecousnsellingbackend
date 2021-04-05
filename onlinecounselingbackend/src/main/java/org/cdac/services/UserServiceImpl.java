package org.cdac.services;

import java.util.ArrayList;
import java.util.List;

import org.cdac.DTO.UserDTO;
import org.cdac.entity.User;
import org.cdac.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	/*
	 * @Autowired MailService emailService;
	 */
	
	@Override
	public boolean registerUser(UserDTO objUser) {
		try {
			User entityUser=new User();
			BeanUtils.copyProperties(objUser, entityUser);
			userRepo.save(entityUser); 
			//emailService.sendMail(objUser.getEmail(),"You have been registered", "Thank you for registering on online counseling sytem, your username is "+objUser);
			return true;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	@Override
	public boolean updateProfile(UserDTO objUser) {
		try {
			
			String username=objUser.getUsername();
			User entity=userRepo.getOne(username);
			
			BeanUtils.copyProperties(objUser, entity);
			userRepo.save(entity); 
			return true;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

//	@Override
//	public List<UserDTO> allUsers() {
//		List<User> allUsers=userRepo.findAll();
//		List<UserDTO> users=new ArrayList<>();
//		for(User objUser:allUsers)
//		{
//			UserDTO tmpUser=new UserDTO();
//			BeanUtils.copyProperties(objUser, tmpUser);
//			users.add(tmpUser);
//		}
//		return users;
//	}

	@Override
	public UserDTO findByUserName(String username) {
		User entity=userRepo.getOne(username);
		UserDTO dto=new UserDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public boolean changePassword(UserDTO dtoObject) {
try {
			
			String username=dtoObject.getUsername();
			String password=dtoObject.getPassword();
			userRepo.updatePassword(password,username); 
			return true;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public String authenticate(UserDTO dtoUser) {
		String username=dtoUser.getUsername();
		User objUser=userRepo.getOne(username);
		if(objUser.getPassword().equals(dtoUser.getPassword()) && objUser.getUserType().equals(dtoUser.getUserType()))
		return objUser.getUserType();
		else
		return("Wrong credentials");
	}


	@Override
	public List<UserDTO> allUsers(String userType) {
		List<User> listUsers=userRepo.listUsers(userType);
		List<UserDTO> dtoUsers=new ArrayList<>();
		for(User objUser:listUsers)
		{
			UserDTO tmpUser=new UserDTO();
			BeanUtils.copyProperties(objUser, tmpUser);
			dtoUsers.add(tmpUser);
		}
		return dtoUsers;
		
	}

}
