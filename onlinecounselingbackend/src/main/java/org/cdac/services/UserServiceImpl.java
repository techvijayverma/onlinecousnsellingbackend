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
	public List<UserDTO> allUsers() {
		List<User> allUsers=userRepo.findAll();
		List<UserDTO> users=new ArrayList<>();
		for(User objUser:allUsers)
		{
			UserDTO tmpUser=new UserDTO();
			BeanUtils.copyProperties(objUser, tmpUser);
			users.add(tmpUser);
		}
		return users;
	}

	@Override
	public UserDTO findByUserName(String username) {
		User entity=userRepo.getOne(username);
		UserDTO dto=new UserDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
