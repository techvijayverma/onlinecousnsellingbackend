package org.cdac.repositories;

import java.util.List;

import org.cdac.entity.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
	@Transactional
	@Modifying
	@Query("update User u set u.password=?1 where u.username=?2")
	public void updatePassword(String password,String username);
	
	
	@Query("select u from User u where u.userType=?1")
	public List<User> listUsers(String userType);
	

}
